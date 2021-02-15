package com.nxpert.customerdtoexample.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nxpert.customerdtoexample.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value="SELECT c from Customer c where lower(c.name) like lower(?1)")
	Page<Customer> search(Pageable pageable, String queriableText);
}
