package jmaster.io.demospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jmaster.io.demospringboot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
