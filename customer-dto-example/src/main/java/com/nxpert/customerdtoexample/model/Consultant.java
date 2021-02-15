package com.nxpert.customerdtoexample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "consultant")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id" ,scope = Consultant.class)
public class Consultant {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	Integer id;

	@Column(name = "name")
	String name;

	@ManyToMany(
			targetEntity = Customer.class, 
	        cascade = {CascadeType.MERGE} )
	@JoinTable(name = "customer_consultants", 
	joinColumns = {
					@JoinColumn(name = "consultants_id") 
				  }, inverseJoinColumns = { @JoinColumn(name = "customer_id") }
  )
	@JsonIdentityReference(alwaysAsId = true)
	List<Customer> customers;

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
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