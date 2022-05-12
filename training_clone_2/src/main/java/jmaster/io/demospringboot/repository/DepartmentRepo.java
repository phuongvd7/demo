package jmaster.io.demospringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jmaster.io.demospringboot.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {


	// JQL
	@Query("SELECT u FROM Department u WHERE u.name LIKE :x")
	Page<Department> search(@Param("x") String s, Pageable pageable);

}
