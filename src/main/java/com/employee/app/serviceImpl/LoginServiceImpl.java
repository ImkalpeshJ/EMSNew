package com.employee.app.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dao.LoginDao;
import com.employee.app.entity.Registration;
import com.employee.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao dao;

	@Override
	public Map<String, Object> login(Registration registration) {
		Registration user = dao.login(registration);
		Map<String, Object> map = new HashMap<String, Object>();
		if(user!=null) {
			map.put("msg", "User is Valid!");
		}else {
			map.put("msg", "Invalid User !");
		}
		map.put("user", user);
		return map;
	}

	@Override
	public String registerNewUser(Registration registration) {
		return dao.registerNewUser(registration);
	}

}
