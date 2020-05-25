package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Laptop;
import com.qlas.repository.LaptopRepo;

@RestController
public class LaptopController 
{
	@Autowired
	LaptopRepo lRepo;
	
	@GetMapping("laptops")
	public List<Laptop> getLaps()
	{
		return lRepo.findAll();
	}

}
