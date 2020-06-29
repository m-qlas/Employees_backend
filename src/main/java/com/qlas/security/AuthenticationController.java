package com.qlas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthenticationController {

	@Autowired
	private MyUserDetailsService myUserDetailService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User checkUser() {
		return null;
	}
}
