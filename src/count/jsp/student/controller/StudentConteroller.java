package count.jsp.student.controller;

import count.jsp.student.dao.StudentCurd;
import count.jsp.student.dto.Student;

public class StudentConteroller {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(14);
		student.setName("priti");
		student.setEmail("jadhapriti@gmail.com");

		StudentCurd studentCurd = new StudentCurd();
		studentCurd.SaveStudent(student);
		studentCurd.deletestudentByID(10);
		studentCurd.getStudentDetailaByID(1);
		studentCurd.updateStudent(student);
	}

}
