package service;

import java.util.List;

import model.Clazz;

public interface ClazzService {
	void input( Clazz c);

	void info( Clazz c);

	void insert( Clazz c);

	void update( Clazz c);

	List<Clazz> searchByCourseName(String Coursename);

	List<Clazz> getAll();

	void delete(int id);
}
