package com.qlas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class EmpDetails {
	@Id
	private int id;

	@JsonBackReference
	@OneToOne
	@MapsId
	private Employee employee;

	@Column(columnDefinition = "DATE")
	private Date hireDate;

	private int salary;
	private String role; 

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpDetails [id=" + id + ", employee=" + employee + ", hireDate=" + hireDate + ", salary=" + salary
				+ ", role=" + role + "]";
	}

	

	
}
