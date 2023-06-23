package com.employee.app.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.app.dao.EmployeeDao;
import com.employee.app.entity.Employee;
import com.employee.app.entity.Status;
import com.employee.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public static Long generateRandomId() {
        Random random = new Random();
        long lowerBound = 100L; // Minimum 3-digit value
        long upperBound = 999L; // Maximum 3-digit value
        long range = upperBound - lowerBound + 1;
        return lowerBound + (long) (range * random.nextDouble());
    }
	
	@Override
	public boolean postEmployee(Employee employee) {
		Date date = Date.valueOf(LocalDate.now());
		employee.setCreatedDate(date);
		employee.setId(generateRandomId());
		boolean isAdded = dao.postEmployee(employee);
		return isAdded;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Date date = Date.valueOf(LocalDate.now());
		employee.setUpdatedDate(date);
		return dao.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(Long id) {
		return dao.deleteEmployee(id);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		return dao.getEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployeeByStatus(Status status) {
		return dao.getEmployeeByStatus(status);
	}

}
