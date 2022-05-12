package jmaster.io.demospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import jmaster.io.demospringboot.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
//	//select student where name = s
//	List<Ticket> findByMajor(String s);
//	
////	Teacher findByMajor(String s);
//	
//	//select student where name LIKE s
//	//JQL
	@Query("SELECT u FROM Ticket u WHERE u.id LIKE :x")
	List<Ticket> search(@Param("x") String s);
//	
////	@Query("SELECT u FROM teacher u WHERE u.id > 1")
////	List<Teacher> searchAI();
}
