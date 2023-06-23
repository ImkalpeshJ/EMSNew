package com.employee.app.service;

import java.util.List;

import com.employee.app.entity.Employee;
import com.employee.app.entity.Status;

public interface EmployeeService {

	boolean postEmployee(Employee employee);

	List<Employee> getAllEmployee();

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(Long id);

	Employee getEmployeeById(Long id);

	List<Employee> getEmployeeByStatus(Status status);
}
