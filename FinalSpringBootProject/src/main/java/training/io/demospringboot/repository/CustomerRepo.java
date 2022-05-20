//package training.io.demospringboot.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import training.io.demospringboot.entity.Customer;
//
//public interface CustomerRepo extends JpaRepository<Customer,Integer>{
//
//		// JQL
//	@Query("SELECT c FROM Customer c WHERE c.name LIKE :x")
//	Page<Customer> search(@Param("x") String s, Pageable pageable);
////	List<Customer> search(@Param("x") String s);
//}