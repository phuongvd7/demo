package jmaster.io.demospringboot.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jmaster.io.demospringboot.entity.Student;
import jmaster.io.demospringboot.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	List<Student> findByCustomerPhone(String phone);
	
	// JQL
	@Query("SELECT u FROM Ticket u WHERE u.createdAt >= :from")
	List<Student> searchByFrom(@Param("from") Date from);

	@Query("SELECT u FROM Ticket u WHERE u.createdAt <= :to")
	List<Student> searchByTo(@Param("to") Date to);
	
	@Query("SELECT u FROM Ticket u WHERE u.createdAt >= :from "
			+ "AND u.createdAt <= :to")
	List<Student> searchByFromTo(@Param("from") Date from, 
			@Param("to") Date to);
	
	@Query("SELECT u FROM Ticket u JOIN u.department d "
			+ "WHERE d.id = :dId")
	List<Student> searchByDepartment(@Param("dId") int departmentId);
}
