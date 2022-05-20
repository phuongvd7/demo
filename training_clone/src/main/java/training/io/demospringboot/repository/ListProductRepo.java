package training.io.demospringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import training.io.demospringboot.entity.ListProduct;


public interface ListProductRepo extends JpaRepository<ListProduct, Integer> {

	
	@Query("SELECT l FROM ListProduct l INNER JOIN Customer c ON l.customer.id = c.id WHERE c.name LIKE :name")
	Page<ListProduct> searchByName(@Param("name") String name, Pageable pageable);
	
	@Query("SELECT l FROM ListProduct l INNER JOIN Customer c ON l.customer.id = c.id WHERE c.id = :id")
	Page<ListProduct> searchById(@Param("id") int id, Pageable pageable);

}
