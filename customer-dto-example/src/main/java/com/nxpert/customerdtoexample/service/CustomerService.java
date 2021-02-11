package com.nxpert.customerdtoexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.model.Customer;

public interface CustomerService {
	

	Customer create(Customer request);

	Page<CustomerDto> readAll(Pageable pageable);

	Customer update(Customer request);

	void delete(Integer id);

	Page<CustomerDto> search(Pageable pageable, String searchText);

	Optional<Customer> read(Integer id);

	Page<CustomerDto> readByConsultantId(Pageable pageable, Integer id);

}
