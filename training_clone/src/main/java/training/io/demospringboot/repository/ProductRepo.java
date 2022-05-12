package training.io.demospringboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import training.io.demospringboot.entity.Customer;
import training.io.demospringboot.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

		// JQL
//	@Query("SELECT u FROM Product u WHERE u.name LIKE :x")
//	Page<Product> search(@Param("x") String s, Pageable pageable);
	@Query("SELECT c FROM Product c WHERE c.name LIKE :x")
	Page<Product> search(@Param("x") String s, Pageable pageable);

}