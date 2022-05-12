package service;

import java.util.List;

import model.Person;
import model.Student;
import model.Teacher;

public interface PersonService {
	void input(Person p);
	
	void info(Person p);
	
	//luu xuong file/db
	void insert(Person p);
	
	void update(Person p);
	void delete(int  id);

	List<Person> getAll();
	Person get(String code);
	
	
}
