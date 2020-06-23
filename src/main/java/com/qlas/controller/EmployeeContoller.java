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
import com.qlas.model.Laptop;
import com.qlas.model.Manager;
import com.qlas.repository.EmpRepo;
import com.qlas.repository.LaptopRepo;
import com.qlas.repository.SalaryRepo;

@RestController
public class EmployeeContoller {

	@Autowired
	EmpRepo eRepo;
	@Autowired
	SalaryRepo sRepo;
	@Autowired
	LaptopRepo lRepo;

	@GetMapping("employees")
	public List<Employee> getEmp() {

		// return eRepo.getEmps();
		return eRepo.findAll();
	}

	@GetMapping("employee/{id}")
	public Employee getEmp(@PathVariable int id) {
		if (eRepo.findById(id).isPresent())
			return eRepo.findById(id).get();
		else
			return new Manager();
	}

	@PostMapping("employee")
	public Employee addEmp(@RequestBody Employee emp) {
		eRepo.save(emp);
		
		int lId = emp.getLaps().get(0).getlId();
		lRepo.changeLaptopOwner(emp, lId);
		return emp;
	}

	@DeleteMapping("employee/{id}")
	public String deleteEmp(@PathVariable int id) {
		System.out.println("Deleting started");

		List<Laptop> laps = eRepo.findById(id).get().getLaps();
		for (Laptop l : laps) {
			l.setEmployee(null);
			System.out.println("Laptop nr: " + l.getlId() + " is free to use now");
		}
		eRepo.deleteById(id);
		return "Employee: " + id + " deleted";
	}

}
