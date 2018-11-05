package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
		public List<String> loadStudents(){
			List<String> studentNames= new ArrayList<String>();
			Connection myConn= this.Connector();
			try {
					Statement myStmt= myConn.createStatement();
					String sql = "select name from studenttable";
					ResultSet myRs= myStmt.executeQuery(sql);
					while (myRs.next()) {
						String name= myRs.getString("name");
						studentNames.add(name);
					}
					this.close(myConn, myStmt, myRs);
					return studentNames;
			} catch (SQLException e) {
					e.printStackTrace();
			}
			return null;
		}
		public Connection Connector(){
			try {
				Connection connection =
				DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","123456");
				return connection;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
				}
				}
		private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
			try{
			if(myStmt!=null)
			myStmt.close();
			if(myRs!=null)
			myRs.close();
			if(myConn!=null)
			myConn.close();
			}
			catch(Exception e){
			System.out.println(e.getMessage());
			}
			}
		public Student fetchStudentByName(String name) {
			Student s = null;
			Connection myConn= Connector();
			try {
			Statement myStmt= myConn.createStatement();
			String sql = "select * from studenttable where name=\""+ name+"\"";
			ResultSet myRs= myStmt.executeQuery(sql);
			while (myRs.next()) {
			int id=myRs.getInt("id");
			String gender= myRs.getString("gender");
			LocalDate birth=null;
			if (myRs.getDate("dateofbirth")!=null) {
			birth = myRs.getDate("dateofbirth").toLocalDate();
			}
			String photo = myRs.getString("photo");
			float mark = myRs.getFloat("mark");
			String comments= myRs.getString("comments");
			s = new Student(id,name,gender,birth,photo,mark,comments);
			}
			this.close(myConn, myStmt, myRs);
			return s;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
				}
				}
}
