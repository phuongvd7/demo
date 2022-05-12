package jmaster.io.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jmaster.io.demospringboot.entity.Student;

public interface StudentRepo 
	extends JpaRepository<Student, Integer> {

	//select student where name = s
	List<Student> findByName(String s);
	
	Student findByUsername(String s);
	
	//select student where name LIKE s
	//JQL
	@Query("SELECT u FROM Student u WHERE u.name LIKE :x")
	List<Student> search(@Param("x") String s);

	@Query("SELECT u FROM Student u WHERE u.id > 1")
	List<Student> searchAI();
}
