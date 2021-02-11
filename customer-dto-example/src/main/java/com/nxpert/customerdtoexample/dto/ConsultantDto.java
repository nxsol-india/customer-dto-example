package com.nxpert.customerdtoexample.dto;

import java.util.List;

import javax.persistence.Column;

import com.nxpert.customerdtoexample.model.Customer;

public class ConsultantDto {
	Integer id;
	String name;
	List<CustomerDto> customer;
	
	
	public List<CustomerDto> getCustomer() {
		return customer;
	}
	public void setCustomer(List<CustomerDto> customer) {
		this.customer = customer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
