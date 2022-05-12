package jmaster.io.demospringboot.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jmaster.io.demospringboot.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	Page<Ticket> findByCustomerPhone(String phone, Pageable pageable);
	
	// JQL
	@Query("SELECT u FROM Ticket u WHERE u.createdAt >= :from")
	Page<Ticket> searchByFrom(@Param("from") Date from, Pageable pageable);

	@Query("SELECT u FROM Ticket u WHERE u.createdAt <= :to")
	Page<Ticket> searchByTo(@Param("to") Date to, Pageable pageable);
	
	@Query("SELECT u FROM Ticket u WHERE u.createdAt >= :from "
			+ "AND u.createdAt <= :to")
	Page<Ticket> searchByFromTo(@Param("from") Date from, 
			@Param("to") Date to, Pageable pageable);
	
	@Query("SELECT u FROM Ticket u JOIN u.department d "
			+ "WHERE d.id = :dId")
	Page<Ticket> searchByDepartment(@Param("dId") int departmentId, Pageable pageable);
	
	@Query("SELECT u FROM Ticket u JOIN u.department d "
			+ "WHERE d.id = :dId AND u.createdAt >= :from "
			+ " AND u.createdAt <= :to AND u.customerPhone = :phone")
	Page<Ticket> searchByAll(@Param("dId") int departmentId,
			@Param("from") Date from, 
			@Param("to") Date to,
			@Param("phone") String phone,
			Pageable pageable);
}