package com.qlas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.qlas.repository.*;

@RestController
public class SalaryController 
{
	@Autowired
	SalaryRepo sRepo;

}
