package com.nxpert.customerdtoexample.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.Array;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.model.Customer;

public class ModelToDto {

	public Page<CustomerDto> convertModelToDto(Page<Customer> list) {

		List<CustomerDto> listOfCustomerDto = new ArrayList<>();
		for (Customer c : list) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setId(c.getId());
			customerDto.setName(c.getName());
			customerDto.setConsultants(convertListOfDto(c.getConsultants()));

			listOfCustomerDto.add(customerDto);
		}
		Page<CustomerDto> page = new PageImpl<>(listOfCustomerDto);

		return page;

	}
	
	public Page<ConsultantDto> convertModelToDtoConsultatn(Page<Consultant> list) {

		List<ConsultantDto> listOfConsultantDto = new ArrayList<>();
		for (Consultant c : list) {
			ConsultantDto consultatnDto = new ConsultantDto();
			consultatnDto.setId(c.getId());
			consultatnDto.setName(c.getName());
			consultatnDto.setCustomer(convertListCustomerToDto(c.getCustomers()));

			listOfConsultantDto.add(consultatnDto);
		}
		Page<ConsultantDto> page = new PageImpl<>(listOfConsultantDto);

		return page;

	}


	private List<CustomerDto> convertListCustomerToDto(List<Customer> customers) {
		List<CustomerDto> listOfCustomer = new ArrayList<>();
		for (Customer c : customers) {
			CustomerDto consulatnDto = new CustomerDto();
			consulatnDto.setId(c.getId());
			consulatnDto.setName(c.getName());
			listOfCustomer.add(consulatnDto);
		}
		return listOfCustomer;
	}

	List<ConsultantDto> convertListOfDto(List<Consultant> listOfConsultant) {
		List<ConsultantDto> listOfConsulat = new ArrayList<>();
		for (Consultant c : listOfConsultant) {
			ConsultantDto consulatnDto = new ConsultantDto();
			consulatnDto.setId(c.getId());
			consulatnDto.setName(c.getName());
			listOfConsulat.add(consulatnDto);
		}
		return listOfConsulat;

	}

	/*
	 * public CustomerDto convertModelToDtoSingle(Page<Customer> object) {
	 * CustomerDto customerDto = null; for (Customer c : object) { //CustomerDto
	 * customerDto = new CustomerDto(); customerDto.setId(c.getId());
	 * customerDto.setName(c.getName());
	 * customerDto.setConsultants(convertListOfDto(c.getConsultants())); } return
	 * customerDto; }
	 */

}
