package com.nxpert.customerdtoexample.mapper;

import java.util.ArrayList;
import java.util.List;

import com.nxpert.customerdtoexample.dto.ConsultantDto;
import com.nxpert.customerdtoexample.dto.CustomerDto;
import com.nxpert.customerdtoexample.model.Consultant;
import com.nxpert.customerdtoexample.model.Customer;

public class DtoToEntity {

	public Customer customerDtoToCustomerEntity(CustomerDto request) {
		Customer customer = new Customer();
		customer.setName(request.getName());
		List<Consultant> listOfConsulatnt = consultantDtoList(request.getConsultants());
		customer.setConsultants(listOfConsulatnt);
		return customer;

	}
	
	public List<Consultant> consultantDtoList(List<ConsultantDto> dtoList){
		List<Consultant> list = new ArrayList<>();
		for (ConsultantDto c : dtoList ) {
			Consultant consultant = new Consultant();
			consultant.setName(c.getName());
			list.add(consultant);

		}
		return list;
		
	}

}
