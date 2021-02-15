package com.nxpert.customerdtoexample.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.model.Customer;

public class ModelToDto {

	public CustomerDto convertModelToDto_Customer(Customer c) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(c.getId());
		customerDto.setName(c.getName());
		customerDto.setConsultants(convertListOfDto_ListConsultantDto(c.getConsultants()));
		return customerDto;
	}

	public Page<CustomerDto> convertModelToDto_PageCustomerDto(Page<Customer> list) {
		List<CustomerDto> listOfCustomerDto = new ArrayList<>();
		for (Customer c : list) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setId(c.getId());
			customerDto.setName(c.getName());
			customerDto.setConsultants(convertListOfDto_ListConsultantDto(c.getConsultants()));

			listOfCustomerDto.add(customerDto);
		}
		Page<CustomerDto> page = new PageImpl<>(listOfCustomerDto, list.getPageable(), list.getTotalElements());
		return page;
	}

	public Page<ConsultantDto> convertModelToDtoConsultatn_PageCounsultantDto(Page<Consultant> list) {
		List<ConsultantDto> listOfConsultantDto = new ArrayList<>();
		for (Consultant c : list) {
			ConsultantDto consultatnDto = new ConsultantDto();
			consultatnDto.setId(c.getId());
			consultatnDto.setName(c.getName());
			consultatnDto.setCustomer(convertListCustomerToDto_ListCustomerDto(c.getCustomers()));

			listOfConsultantDto.add(consultatnDto);
		}
		Page<ConsultantDto> page = new PageImpl<>(listOfConsultantDto, list.getPageable(), list.getTotalElements());
		return page;
	}

	private List<CustomerDto> convertListCustomerToDto_ListCustomerDto(List<Customer> customers) {
		List<CustomerDto> listOfCustomer = new ArrayList<>();
		for (Customer c : customers) {
			CustomerDto consulatnDto = new CustomerDto();
			consulatnDto.setId(c.getId());
			consulatnDto.setName(c.getName());
			listOfCustomer.add(consulatnDto);
		}
		return listOfCustomer;
	}

	List<ConsultantDto> convertListOfDto_ListConsultantDto(List<Consultant> listOfConsultant) {
		List<ConsultantDto> listOfConsulat = new ArrayList<>();
		for (Consultant c : listOfConsultant) {
			ConsultantDto consulatnDto = new ConsultantDto();
			consulatnDto.setId(c.getId());
			consulatnDto.setName(c.getName());
			listOfConsulat.add(consulatnDto);
		}
		return listOfConsulat;

	}

}
