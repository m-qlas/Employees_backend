package com.qlas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
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

	@GetMapping("employee/id/{id}")
	public List<Employee> getEmp(@PathVariable int id) {
		System.out.println("Finding by ID");
		if (eRepo.findById(id)!=null)
			return eRepo.findById(id);
		else
			return new ArrayList<Employee>();
	}
	
	@GetMapping("employee/name/{name}")
	public List<Employee> getEmpByName(@PathVariable String name) {
		System.out.println("Finding by Name");
		if (eRepo.findByName(name)!=null)
			return eRepo.findByName(name);
		else
			return new ArrayList<Employee>();
	}
	
	@GetMapping("employee/tech/{tech}")
	public List<Employee> getEmpByTech(@PathVariable String tech) {
		System.out.println("Finding by Tech");
		if (eRepo.findByTech(tech)!=null)
			return eRepo.findByTech(tech);
		else
			return new ArrayList<Employee>();
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

		List<Laptop> laps = eRepo.findById(id).get(0).getLaps();
		for (Laptop l : laps) {
			l.setEmployee(null);
			System.out.println("Laptop nr: " + l.getlId() + " is free to use now");
		}
		eRepo.deleteById(id);
		return "Employee: " + id + " deleted";
	}

}
