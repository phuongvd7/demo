package jmaster.io.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.demospringboot.entity.Course;

public interface CourseRepo 
	extends JpaRepository<Course, Integer> {

}
