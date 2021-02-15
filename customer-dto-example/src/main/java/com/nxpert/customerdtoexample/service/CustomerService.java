package com.nxpert.customerdtoexample.service;

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

	CustomerDto read(Integer id);

}
