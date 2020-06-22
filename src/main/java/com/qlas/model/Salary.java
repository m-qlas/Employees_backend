package com.qlas.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Salary {
	@Id
	private int sId;

	@JsonBackReference
	@OneToOne
	@MapsId
	private Employee employee;

	@Column(columnDefinition = "DATE")
	private Date dateFrom;

	@Column(columnDefinition = "DATE")
	private Date dateTo;
	private int salary;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Salary [dateFrom=" + dateFrom + ", dateTo=" + dateTo + ", salary=" + salary + ", employee=" + employee
				+ "]";
	}

}
