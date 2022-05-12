package service;

import java.util.List;



import model.Person;
import model.Student;
import model.Teacher;

public interface StudentService {
	void input(Student p);
	
	void info(Student p);
	
	void insert(Student p);
	
	void update(Student p);
	void delete(int  id);
	
	//doc ds course tu file/db

	
	List<Student> getAll();


	
	
}
