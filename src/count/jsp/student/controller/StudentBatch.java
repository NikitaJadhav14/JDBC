package count.jsp.student.controller;

import java.util.ArrayList;

import count.jsp.student.dao.StudentCurd;
import count.jsp.student.dto.Student;

public class StudentBatch {

	public static void main(String[] args) {
		StudentCurd studentCurd=new StudentCurd();
		Student s1=new Student();
		s1.setId(11);
		s1.setName("nik");
		s1.setEmail("niki@1123");
		
		
		Student s2=new Student();
		s2.setId(12);
		s2.setName("nikita");
		s2.setEmail("nikiita@1123");
		
		
		Student s3=new Student();
		s3.setId(13);
		s3.setName("dip");
		s3.setEmail("dip@1123");
		
		
		ArrayList<Student>arraylist=new ArrayList<Student>();
		arraylist.add(s1);
		arraylist.add(s2);
		arraylist.add(s3);
		studentCurd.addStudentBatch(arraylist);

	}

}
