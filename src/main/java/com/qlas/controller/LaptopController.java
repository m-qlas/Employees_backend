package com.qlas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.model.Employee;
import com.qlas.model.Laptop;
import com.qlas.repository.LaptopRepo;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class LaptopController {
	@Autowired
	LaptopRepo lRepo;

	@GetMapping("laptops")
	public List<Laptop> getLaps() {
		return lRepo.findAll();
	}

	@GetMapping("laps")
	public List<Laptop> getFreeLaps() {
		List<Laptop> freeLaps = lRepo.findAll();
		List<Laptop> toDelete = new ArrayList<>();
		for (Laptop l : freeLaps) {
			if (l.getEmployee() != null) {
				toDelete.add(l);
			}
		}
		freeLaps.removeAll(toDelete);
		return freeLaps;
	}
	
	@PutMapping("laptop/{id}")
	public Laptop setLapFree(@PathVariable int id) {
		lRepo.changeLaptopOwner(null, id);
		Laptop l = lRepo.findById(id).get();
		return l;
	}
	
	@PutMapping("laptop/update/{id}")
	public Laptop changeOwner(@RequestBody Employee emp, @PathVariable int id) {
		lRepo.changeLaptopOwner(emp, id);
		Laptop l = lRepo.findById(id).get();
		return l;
	}
	
	@PostMapping("laptop")
	public Laptop addLaptop(@RequestBody Laptop lap) {
		System.out.println(lap);
		return lRepo.save(lap);
	}

}
