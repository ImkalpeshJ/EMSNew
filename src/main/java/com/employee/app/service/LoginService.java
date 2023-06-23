package com.employee.app.service;

import java.util.Map;

import com.employee.app.entity.Registration;

public interface LoginService {
	Map<String, Object> login(Registration registration);

	String registerNewUser(Registration registration);
}
