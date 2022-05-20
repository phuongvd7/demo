/**
 * 
 */
package training.io.demospringboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import training.io.demospringboot.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT c FROM Product c WHERE c.name LIKE :name")
	Page<Product> searchByName(@Param("name") String name, Pageable pageable);
}
