package com.employee.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Employee {

	@Id
	private Long id;
	
	@Column(name = "Employee_name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "Emailid", nullable = false)
	private String emailId;
	
	@Column(name = "Mobile_number", nullable = false)
	private String mobileNo;
	
	@Column(name = "status", nullable = false)
	private Status status;
	
	@Column(name = "department", nullable = false)
	private String department;
	
	@Column(name = "created_by", nullable = true)
	private String createdBy;
	
	@Column(name = "updated_by", nullable = true)
	private String updatedBy;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = true)
	private Date updatedDate;
	
	@OneToOne
	private Country country;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, String emailId, String mobileNo, Status status, String department,
			String createdBy, String updatedBy, Date createdDate, Date updatedDate, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
		this.status = status;
		this.department = department;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
