package application;

import java.time.LocalDate;

public class Student {
	
	int Id;
	String Name;
	String Gender;
	LocalDate Birthdate;
	String Photo;
	float Mark;
	String Comments;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public LocalDate getBirthdate() {
		return Birthdate;
	}
	public void setBirthdate(LocalDate birthdate) {
		Birthdate = birthdate;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public float getMark() {
		return Mark;
	}
	public void setMark(float mark) {
		Mark = mark;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	public Student(int id, String name, String gender, LocalDate birthdate, String photo, float mark,
			String comments) {
		super();
		Id = id;
		Name = name;
		Gender = gender;
		Birthdate = birthdate;
		Photo = photo;
		Mark = mark;
		Comments = comments;
	}
	public Student(String name, String gender) {
		super();
		Name = name;
		Gender = gender;
	}
	

}
