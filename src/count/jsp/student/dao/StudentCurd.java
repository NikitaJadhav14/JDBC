package count.jsp.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import count.jsp.student.dto.Student;
import count.jsp.student.util.HelperClass;

public class StudentCurd {
   HelperClass helperClass =new HelperClass();
  
   public void SaveStudent (Student student) {
	   Connection connection=helperClass.getConnection();
	   String sql="INSERT INTO student VALUES(?,?,?)";
	   try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,student.getId());
		preparedStatement.setString(2,student.getName());
		preparedStatement.setString(3,student.getEmail());
		
		boolean f=preparedStatement.execute();
		if(f) {
			System.out.println("Student inserted in the database");
		}else {
			System.out.println("not good");
		}
		if(connection !=null) {
			connection.close();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   
	   public void deletestudentByID(int id) {
		   Connection connection=helperClass.getConnection();
		   String sql="DELETE FROM student where ID=?"; 
		   try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			int ID = preparedStatement.executeUpdate();
			if(ID>0) {
				System.out.println("delete Student");
				}else {
					System.out.println("not deleted");
				}
			if(connection !=null) {
				connection.close();
			}
			
		   } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public void getStudentDetailaByID(int id) {
		   Connection connection=helperClass.getConnection();  
		   String sql ="SELECT *FROM student where id=?";
		   try {
		   PreparedStatement preparedStatement=connection.prepareStatement(sql);
		   preparedStatement.setInt(1,id);
		   
		   ResultSet resultSet=preparedStatement.executeQuery();
		   while(resultSet.next()) {
			   int id2=resultSet.getInt(1);
			   String Name =resultSet.getString(2);
			   String Email=resultSet.getString(3);
			   System.out.println("================");
			   System.out.println("Name of The student Id "+ Name);
			   System.out.println("Email Id of the student is "+ Email);
			   System.out.println("================");
		   }
		   }
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	   }
	   public void updateStudent(Student student) {
		   Connection connection=helperClass.getConnection();  
		   String sql ="UPDATE student SET Name =?,Email=? WHERE ID=?"; 
		   try {
			   PreparedStatement preparedStatement=connection.prepareStatement(sql);
			   preparedStatement.setString(1,student.getName());
			   preparedStatement.setString(2,student.getEmail());
			  
			   preparedStatement.setInt(3,student.getId());
			 int a= preparedStatement.executeUpdate();
			 if(a>0) {
				 System.out.println("update Deteil");
				 }
			 else {
				 System.out.println("Not Update");
			 }
		   }
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 }
	   public void addStudentBatch(List<Student>list) {
		   Connection connection=helperClass.getConnection(); 
		   String sql="INSERT INTO student VALUES(?,?,?)";
		   PreparedStatement preparedStatement;
		   try {
		   PreparedStatement preparedStatement1=connection.prepareStatement(sql);
		   for(Student s:list) {
			   preparedStatement1.setInt(1,s.getId());
			   preparedStatement1.setString(2,s.getName());
			   preparedStatement1.setString(3,s.getEmail());
			  
			   
			  preparedStatement1.addBatch();
			  
			  System.out.println("Student With "+s.getName()+" added inside the database");
		   }
		   preparedStatement1.executeBatch();
		   if(connection!=null)
			   connection.close();
	   }
		   catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }

}