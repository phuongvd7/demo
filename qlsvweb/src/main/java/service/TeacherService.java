package service;

import java.util.List;



import model.Person;
import model.Student;
import model.Teacher;

public interface TeacherService {
	void input(Teacher p);
	
	void info(Teacher p);
	
	void insert(Teacher p);
	
	void update(Teacher p);
	
	void delete(int  id);
	
	//doc ds course tu file/db

	
	List<Teacher> getAll();

//	List<Teacher> read();
	// chi su dung cho tham so duy nhat
	//Teacher get(String code);
	
	
}
