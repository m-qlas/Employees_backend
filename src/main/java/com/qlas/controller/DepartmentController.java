package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Department;
import com.qlas.repository.DepartmentRepo;



@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class DepartmentController {
	@Autowired
	DepartmentRepo dRepo;
	
	@GetMapping("departments")
	public List<Department> getDeps(){
		return dRepo.findAll(); 
	}
	
	
}
