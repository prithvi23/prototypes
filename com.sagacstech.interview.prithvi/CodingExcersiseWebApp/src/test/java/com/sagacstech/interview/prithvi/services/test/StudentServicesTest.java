/**
 * @(#)StudentServicesTest.java
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
package com.sagacstech.interview.prithvi.services.test;

import java.util.HashMap;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sagacstech.interview.prithvi.services.interfaces.IStudentService;
import com.sagacstech.interview.prithvi.services.models.Student;
import com.sagacstech.interview.prithvi.services.utils.AppUtils;
import com.sagacstech.interview.prithvi.web.utils.JsonUtils;

/**
 * All unit tests
 * @author Prithvi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/conf/spring/test-application-context.xml" })
public class StudentServicesTest {
	
	private Logger logger = LoggerFactory.getLogger(StudentServicesTest.class);
	
	/**
	 * Inject the service that is being tested
	 */
	@Autowired
	private IStudentService studentService;
	
	/**
	 * Complete Student Crud
	 */
	@Test
	public void testAll(){
		String firstName = RandomStringUtils.randomAlphabetic(10);
		String lastName = RandomStringUtils.randomAlphabetic(5);
		Student student = new Student(firstName,lastName,AppUtils.join(firstName,AppUtils.PERIOD,lastName,AppUtils.EMAIL),AppUtils.PHONE);
		try {
			System.out.println(JsonUtils.marshall(student));
			studentService.create(student);
			Assert.assertNotNull(student.get_id());
			Assert.assertNotNull(student.getUniqueId());
			Assert.assertNotNull(studentService.read(student.get_id()));
			Assert.assertNotNull(studentService.readByUniqueId(student.getUniqueId()));
			Assert.assertNotNull(studentService.fetch(new HashMap<String,Object>(), 1).get(0));
			student.setLastName("Raj");
			studentService.update(student);
			Assert.assertTrue(studentService.read(student.get_id()).getLastName().equals("Raj"));
			Assert.assertTrue(studentService.delete(student));
			Assert.assertNull(studentService.read(student.get_id()));
		} catch (Exception e) {
			logger.error("Error{}",e);
			Assert.fail();
		}
	}
}
