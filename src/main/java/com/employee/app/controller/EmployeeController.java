package com.employee.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.app.entity.Employee;
import com.employee.app.entity.Status;
import com.employee.app.service.EmployeeService;
import com.employee.app.exception.ResourceAlreadyExistsException;
import com.employee.app.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping(value = "/post-employee")
	public ResponseEntity<String> postEmployee(@RequestBody Employee employee) {
		boolean isAdded = service.postEmployee(employee);
		if (isAdded) {
			return new ResponseEntity<String>("Employee with id " + employee.getId() + " is created!", HttpStatus.OK);
		}
		throw new ResourceAlreadyExistsException("Employee already exists with id " + employee.getName());
	}

	@GetMapping(value = "/get-all-employee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> employees = service.getAllEmployee();
		if (employees.isEmpty()) {
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@PutMapping(value = "/update-employee")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		boolean isUpdated = service.updateEmployee(employee);
		if (isUpdated) {
			return new ResponseEntity<String>("Employee with id " + employee.getId() + " is updated!", HttpStatus.OK);
		}
		throw new RuntimeException("Failed to update Employee!");
	}

	@GetMapping(value = "/get-employee-by-id/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = service.getEmployeeById(id);
		if (employee != null) {
			return ResponseEntity.ok(employee);
		}
		throw new ResourceNotFoundException("No such employee with id " + id);
	}

	@DeleteMapping(value = "/delete-employee")
	public ResponseEntity<String> deleteEmployee(@RequestParam Long id) {
		boolean isDeleted = service.deleteEmployee(id);
		if (isDeleted) {
			return new ResponseEntity<String>("Employee with id " + id + " is deleted!", HttpStatus.OK);
		}
		throw new ResourceNotFoundException("No such employee with id " + id);
	}

	@GetMapping(value = "/get-employee-by-status")
	public ResponseEntity<List<Employee>> getEmployeeByStatus(@RequestParam Status status) {
		List<Employee> employees = service.getEmployeeByStatus(status);
		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("Currently no employee present with status :-" + status);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
}
