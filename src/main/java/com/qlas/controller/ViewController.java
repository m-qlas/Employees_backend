package com.qlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String view() {
		System.out.println("Function started");
		return "index.html";
	}
}
