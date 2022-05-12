package jmaster.io.service;

import java.util.List;

import jmaster.io.model.Person;
import jmaster.io.model.Student;
import jmaster.io.model.Teacher;

public interface PersonService {
	void input(Person p);
	
	void info(Person p);
	
	//luu xuong file/db
	void insert(Person p);
	
	//doc ds course tu file/db
	List<Student> getAllStudents();
	
	List<Teacher> getAllTeachers();
	
}
