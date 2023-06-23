package com.employee.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Registration {

	@Id
	private int id;
	@Column(nullable = true)
	private String fname;
	@Column(nullable = true)
	private String lname;
	@Column(nullable = true)
	private Gender gender;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = true)
	private String mobileNo;
	@Column(nullable = true)
	private String createdBy;
	@Column(nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdDate;
	@Column(nullable = true)
	private String updatedBy;
	@Column(nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedDate;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(int id, String fname, String lname, Gender gender, String email, String password,
			String mobileNo, String createdBy, Date createdDate, String updatedBy, Date updatedDate) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", fname=" + fname + ", lname=" + lname + ", gender=" + gender + ", email="
				+ email + ", password=" + password + ", mobileNo=" + mobileNo + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
}
