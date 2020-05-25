package com.qlas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Car;
import com.qlas.repository.CarRepo;

@RestController
public class CarController 
{
	@Autowired
	CarRepo cRepo;
	
	@GetMapping("cars")
	public List<Car> getCats()
	{
		return cRepo.findAll();
	}

}
