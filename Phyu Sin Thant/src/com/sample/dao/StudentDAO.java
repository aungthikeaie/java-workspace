package com.sample.dao;

import java.util.ArrayList;
import java.util.List;

import com.sample.model.Student;

public class StudentDAO 
{

	public static List<Student> getStudents()
	{
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1,"mama","mama@gmail.com"));
		studentList.add(new Student(2,"koko","koko@gmail.com"));
		studentList.add(new Student(3,"susu","susu@gmail.com"));
		
		return studentList;
	}
}
