package jmaster.io.service;

import java.util.List;

import jmaster.io.model.Course;

public interface CourseService {
	void input(Course course);

	void info(Course course);
	
	// luu xuong file/db
	void insert(Course course);
	// doc ds nhung khoa hoc tu file/db
	List<Course> getAll();
	
	
}
