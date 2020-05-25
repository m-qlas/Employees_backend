package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Employee;
import com.qlas.repository.EmpRepo;
import com.qlas.repository.SalaryRepo;

@RestController
public class EmployeeContoller 
{
	@Autowired
	EmpRepo eRepo;
	@Autowired
	SalaryRepo sRepo;
	
	@GetMapping("employees")
	public List<Employee> getEmp() {
		
		return eRepo.findAll();
	}
	
	@GetMapping("employee/{id}")
	public Employee getEmp(@PathVariable int id)
	{
		return eRepo.findById(id).get();
	}

}
