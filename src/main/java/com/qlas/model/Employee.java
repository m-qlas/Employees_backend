package com.qlas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Position", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("E")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "employee") // , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Laptop> laps;

	@JsonManagedReference
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private EmpDetails eDetails;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;
	
	@JsonBackReference
	@ManyToOne
	private Department department;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

//	public String getManagerFirstName() {
//
//		return manager.getFirstName();
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		this.firstName = fName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		this.lastName = lName;
	}

	
	public List<Laptop> getLaps() {
		return laps;
	}

	public void setLaps(List<Laptop> laps) {
		this.laps = laps;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public String getDepartmentName() {
		return department.getName();
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmpDetails geteDetails() {
		return eDetails;
	}

	public void seteDetails(EmpDetails eDetails) {
		this.eDetails = eDetails;
	}
	
	
}
