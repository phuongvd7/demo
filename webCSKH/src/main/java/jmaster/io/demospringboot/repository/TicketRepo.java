package jmaster.io.demospringboot.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jmaster.io.demospringboot.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("SELECT u FROM Ticket u WHERE u.createdAt >= :x")
	List<Ticket> searchByFrom(@Param("x") Date x);
	
	@Query("SELECT u FROM Ticket u WHERE u.createdAt <= :to")
	List<Ticket> searchByTo(@Param("to") Date to);
	
	@Query("SELECT u FROM Ticket u WHERE u.createdAt => :from AND u.createdAt <= :to")
	List<Ticket> searchByFromTo(@Param("from") Date from, @Param("to") Date to);
	
	@Query("SELECT u FROM Ticket u JOIN u.department d WHERE d.id = :dId")  // de quan he join ben department roi nen khong can join on
	List<Ticket> searchByDepartment(@Param("dId") int departmentId);

}
