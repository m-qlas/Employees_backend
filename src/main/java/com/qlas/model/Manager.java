package com.qlas.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("M")
public class Manager extends Employee {

//	@JsonManagedReference
//	@OneToMany(mappedBy = "manager")
//	private List<Employee> subordinates;

	@JsonManagedReference
	@OneToOne(mappedBy = "manager")
	private Car car;
	
	@JsonBackReference
	@OneToOne
	@MapsId
	private Department department;

//	public List<Employee> getSubordinates() {
//		return subordinates;
//	}
//
//	public void setSubordinates(List<Employee> subordinates) {
//		this.subordinates = subordinates;
//	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

		
}
