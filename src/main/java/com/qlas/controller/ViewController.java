package com.qlas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	@RequestMapping("/get")
	public String view() {
		System.out.println("Get controller");
		return "get.html";
	}
	
	@RequestMapping("/login")
	public String loginPage()
	{
		System.out.println("Login controller");
		return "login.html";
	}
	
	@RequestMapping("/logout-succes")
	public String logoutPage()
	{
		System.out.println("Logout controller");
		return "logout.html";
	}
}
