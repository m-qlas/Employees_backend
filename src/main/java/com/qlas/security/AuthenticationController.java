package com.qlas.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {

	
	@GetMapping("/user")
	public String checkUser() 
	{
		String userName;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  userName = ((UserDetails)principal).getUsername();
		} else {
		  userName = principal.toString();
		}
		
		return userName;
	}
}
