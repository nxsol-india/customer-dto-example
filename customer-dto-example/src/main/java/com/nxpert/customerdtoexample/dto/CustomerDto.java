package com.nxpert.customerdtoexample.dto;

import java.util.List;

public class CustomerDto {
	Integer id;
	String name;
	List<ConsultantDto> consultants; 
	
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
	public List<ConsultantDto> getConsultants() {
		return consultants;
	}
	public void setConsultants(List<ConsultantDto> consultants) {
		this.consultants = consultants;
	}
	
	
}
