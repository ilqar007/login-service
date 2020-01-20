package com.bankapi.microservices.loginserver.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Users")

public class User extends BaseEntity<Long>{

	private static final long serialVersionUID = 1L;
	@Id
	@Access(AccessType.PROPERTY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//@NotNull
	//@Size(min = 1, max = 100)
	//@Pattern(regexp = "[a-zA-Z0-9\\s]+")
	@Access(AccessType.PROPERTY)
	@Column(name = "firstName", nullable = true, length = 100)
	private String firstName;
	@Access(AccessType.PROPERTY)
	@Column(name = "lastName", nullable = true, length = 100)
	private String lastName;
	@Column(name = "phoneNumber", nullable = true, length = 100)
	@Access(AccessType.PROPERTY)
	private String phoneNumber;
	@Column(name = "emailAddress", nullable = true, length = 100)
	@Access(AccessType.PROPERTY)
	private String emailAddress;
	@Column(name = "password", nullable = true, length = 100)
	@Access(AccessType.PROPERTY)
	private String password;
	@Column(name = "gender", nullable = true)
	@Access(AccessType.PROPERTY)
	private int gender;
	

	@Column(name = "dateOfBirth", nullable = true)
	@Access(AccessType.PROPERTY)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	
	
	public User()
	{
		super();
	}
}
