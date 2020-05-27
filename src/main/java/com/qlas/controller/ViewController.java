package com.qlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

	@RequestMapping("/")
	public String view() {
		System.out.println("Default function started");
		return "home.html";
	}
	
	@RequestMapping("/login")
	public String view(@RequestParam("login") String login, @RequestParam("password") String pass) {
		System.out.println("Parameterd function started");
		System.out.println("Login: " + login + " Password: " + pass);
		return "home.html";
	}
}
