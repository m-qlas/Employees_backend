package com.qlas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {
	
	@Id
	private String name;
	
//	@JsonManagedReference
//	@OneToOne(mappedBy = "department")
//	private Manager manager;
	
	@JsonManagedReference(value="empDepRef")
	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private List<Employee> emps;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Employee> getEmps() {
		return emps;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
	
	
	
}
