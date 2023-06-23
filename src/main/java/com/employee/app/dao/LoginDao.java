package com.employee.app.dao;

import com.employee.app.entity.Registration;

public interface LoginDao {
	Registration login(Registration registration);

	String registerNewUser(Registration registration);
}
