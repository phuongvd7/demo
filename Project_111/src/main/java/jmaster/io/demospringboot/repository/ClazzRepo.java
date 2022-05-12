package jmaster.io.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jmaster.io.demospringboot.entity.Clazz;

public interface ClazzRepo 
	extends JpaRepository<Clazz, Integer> {

	@Query("SELECT u FROM Clazz u WHERE u.name LIKE :keyword")
	List<Clazz> search(@Param("keyword") String s);

}
