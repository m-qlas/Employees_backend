package com.qlas.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("M")
public class Manager extends Employee {
	@JsonManagedReference
	@OneToMany(mappedBy = "manager")
	private List<Employee> subordinates;

	@JsonManagedReference
	@OneToOne(mappedBy = "manager")
	private Car car;

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(List<Employee> subordinates) {
		this.subordinates = subordinates;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String getManagerName() {
		return null;

	}

	@Override
	public String toString() {
		return "Manager [subordinates=" + subordinates + ", car=" + car + "]";
	}
}
