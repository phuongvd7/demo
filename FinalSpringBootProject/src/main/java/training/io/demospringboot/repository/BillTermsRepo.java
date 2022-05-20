package training.io.demospringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import training.io.demospringboot.entity.BillTerms;


public interface BillTermsRepo extends JpaRepository<BillTerms, Integer> {

	Page<BillTerms> searchByName(String string, Pageable pageable);

	
//	@Query("SELECT l FROM ListProduct l INNER JOIN Customer c ON l.customer.id = c.id WHERE c.name LIKE :name")
//	Page<BillTerms> searchByName(@Param("name") String name, Pageable pageable);
//	
//	@Query("SELECT l FROM ListProduct l INNER JOIN Customer c ON l.customer.id = c.id WHERE c.id = :id")
//	Page<BillTerms> searchById(@Param("id") int id, Pageable pageable);
	Page<BillTerms> searchById(Integer billId, Pageable pageable);
}
