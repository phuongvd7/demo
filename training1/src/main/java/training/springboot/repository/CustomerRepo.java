//package training.springboot.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import training.spingboot.entity.Customer;
//
//public interface CustomerRepo extends JpaRepository<Customer,Integer>{
//
//		// JQL
////	@Query("SELECT u FROM Customer u WHERE u.name LIKE :x")
////	Page<Customer> search(@Param("x") String s, Pageable pageable);
//
//}