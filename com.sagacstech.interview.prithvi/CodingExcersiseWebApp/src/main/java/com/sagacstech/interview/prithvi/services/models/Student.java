/**
 * @(#)Student.java
 * @author Prithvi
 * @date Apr 10,2015
 *
 * @version 1.0
 *
 * Copyright (c) Sagacstech Owned and operated by Prithvi. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of SagacsTech. ("Confidential Information").
 * Solely written for the interview purpose
 */
package com.sagacstech.interview.prithvi.services.models;

import org.springframework.util.StringUtils;

import com.sagacstech.interview.prithvi.services.interfaces.IAuditable;
import com.sagacstech.interview.prithvi.web.utils.JsonUtils;

/*
 * @author Prithvi
 * The Student pojo
 */
public class Student extends Auditable implements IAuditable {
	private static final long serialVersionUID = 1L;
	public static final String COLLECTION_NAME = "students";	
	/**
	 * First name
	 */
	private String firstName;
	/**
	 * Last name
	 */
	private String lastName;
	/**
	 * Unique id - assigned by the system - not Mongodb
	 */
	private String uniqueId;
	/**
	 * Email address
	 */
	private String email;
	/**
	 * Phone number
	 */
	private String phoneNumber;
	
	/**
	 * Default constructor
	 */
	public Student() {
		super();
	}
	
	/**
	 * All field constructor
	 * @param firstName
	 * @param lastName
	 * @param uniqueId
	 * @param email
	 * @param phoneNumber
	 */
	public Student(String firstName, String lastName, String uniqueId, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.uniqueId = uniqueId;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * All field constructor for new objects
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */
	public Student(String firstName, String lastName, String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	@Override
	public boolean isNew() {
		return StringUtils.isEmpty(uniqueId) && super.isNew();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static void main(String[] args){
		Student student = new Student("Jane","Doe","jane.doe@sagacstech.com","55512345");
		try {
			System.out.println(JsonUtils.marshall(student));
		} catch (Exception e) {
		}
	}
}
