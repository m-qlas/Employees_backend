package com.qlas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Laptop 
{
	@Id
	private int lId;
	@JsonBackReference
	@ManyToOne
	@MapsId
	private Employee employee;
	private String brand;
	private String model;
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", brand=" + brand + ", model=" + model + ", employee=" + employee + "]";
	}
	
	

	
	
}
