package training.io.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import training.io.demospringboot.entity.ListProduct;


public interface ListProductRepo extends JpaRepository<ListProduct, Integer> {


}
