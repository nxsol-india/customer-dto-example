package com.nxpert.customerdtoexample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.mapper.DtoToEntity;
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
		return modelToDto.convertModelToDto(customer);
	}

	@Override
	public Page<CustomerDto> readAll(Pageable pageable) {
		Page<Customer> listOfCustomer = repository.findAll(pageable);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDto(listOfCustomer);
	}

	@Override
	public Optional<Customer> read(Integer id) {
		return repository.findById(id);
	}
	

	@Override
	public Page<CustomerDto> readByConsultantId(Pageable pageable, Integer id) {
		Page<Customer> listOfCustomer =  repository.readByConsultantId(pageable, id);
		ModelToDto modelToDto = new ModelToDto();
		return modelToDto.convertModelToDto(listOfCustomer);
	}

	@Override
	public Customer create(Customer request) {
		// DtoToEntity dtoToEntity = new DtoToEntity();
		// Customer customer = dtoToEntity.customerDtoToCustomerEntity(request);
		repository.save(request);
		return null;
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
