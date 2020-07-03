package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Manager;
import com.qlas.repository.ManagerRepo;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class ManagerController 
{
	@Autowired
	ManagerRepo mRepo;
	
	@GetMapping("managers")
	public List<Manager> getMan()
	{
		return mRepo.findAll();
	}

}
