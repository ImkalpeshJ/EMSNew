package com.employee.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.entity.Registration;
import com.employee.app.exception.SomethingWentWrongException;
import com.employee.app.service.LoginService;

@CrossOrigin
@RestController
@RequestMapping(value = "/register")
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping(value = "/login")
	public Map<String, Object> login(@RequestBody Registration registration) {
		Map<String, Object> map = service.login(registration);
		if (!(map.isEmpty())) {
			return map;
		}
		throw new SomethingWentWrongException("Something went wrong!");
	}
	
	@PostMapping(value= "/new")
	public String registerNewUser(@RequestBody Registration registration) {
		String isRegistered = service.registerNewUser(registration);
		if(isRegistered==null) {
			return "User is not registered!";
		}else {
			return isRegistered;
		}
		
	}

}
