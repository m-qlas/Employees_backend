package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		
		//return eRepo.getEmps();
		return eRepo.findAll();
	}
	
	@GetMapping("employee/{id}")
	public Employee getEmp(@PathVariable int id)
	{
		return eRepo.findById(id).get();
	}
	
	@PostMapping("employee")
	public Employee addEmp(@RequestBody Employee emp)
	{
		eRepo.save(emp);
		return emp;
	}
	
	@DeleteMapping("employee/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		eRepo.deleteById(id);
		return "Employee deleted";
	}

}
