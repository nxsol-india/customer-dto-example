package com.nxpert.customerdtoexample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.mapper.ModelToDto;
import com.nxpert.customerdtoexample.model.Customer;
import com.nxpert.customerdtoexample.repository.CustomerRepository;
import com.nxpert.customerdtoexample.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;

	@Override
	public Page<CustomerDto> search(Pageable pageable, String searchText) {
		String queriableText = new StringBuilder("%").append(searchText).append("%").toString();
		Page<Customer> customer = repository.search(pageable, queriableText);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDto_PageCustomerDto(customer);
	}

	@Override
	public Page<CustomerDto> readAll(Pageable pageable) {
		Page<Customer> listOfCustomer = repository.findAll(pageable);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDto_PageCustomerDto(listOfCustomer);
	}

	@Override
	public CustomerDto read(Integer id) {
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDto_Customer(repository.findById(id).orElse(null)); 
	}

	@Override
	public Customer create(Customer request) {
		return repository.save(request);
	}

	@Override
	public Customer update(Customer request) {
		return repository.save(request);
	}

	@Override
	public void delete(Integer id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			if (repository.findById(id).isPresent()) {
				System.out.println("not deleted");
			}
		}
	}
}
