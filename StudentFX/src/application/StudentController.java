package application;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StudentController implements Initializable {
	
	DBManager manager;
	@FXML
	ListView<String> lvStudents;
	@FXML
	TextField txtFieldName;
	@FXML
	TextField txtFieldMark;
	@FXML
	ComboBox<String> cmbGender;
	@FXML
	DatePicker dtpckrDate;
	@FXML
	TextArea txtAreaComments;
	@FXML
	ImageView imvPhoto;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manager = new DBManager();
		// TODO Auto-generated method stub
		List<String> gvalues = new ArrayList<String>();
		gvalues.add("Male");
		gvalues.add("Female");
		ObservableList<String> gender = FXCollections.observableArrayList(gvalues);
		cmbGender.setItems(gender);
		
		fetchStudents();
		lvStudents.getSelectionModel().selectedItemProperty().addListener(e-> displayStudentDetails(lvStudents.getSelectionModel().getSelectedItem()));
	}
	public void fetchStudents() {
		ObservableList<String> students;
		if (manager.loadStudents()!=null) {
				students= FXCollections.observableArrayList(manager.loadStudents());
				lvStudents.setItems(students);
		}
		}
	private void displayStudentDetails(String name) {
		try{
		Student s =manager.fetchStudentByName(name);
		txtFieldName.setText(s.getName());
		cmbGender.setValue(s.getGender());
		dtpckrDate.setValue(s.getBirthdate());
		Image image;
		InputStream is = null;
		if(s.getPhoto()!=null) {
		is = new FileInputStream(s.getPhoto());
		image = new Image(is);
		imvPhoto.setImage(image);
		}
		else {
			is = new FileInputStream("C:\\pics\\studentAno.jpg");
			image= new Image (is);
			imvPhoto.setImage(image);
			}
			txtFieldMark.setText(String.valueOf(s.getMark()));
			txtAreaComments.setText(s.getComments());
			}
			catch (Exception e) {
			System.out.println(e.getMessage());
			}
			}
	
	
	
	
	
	

}
