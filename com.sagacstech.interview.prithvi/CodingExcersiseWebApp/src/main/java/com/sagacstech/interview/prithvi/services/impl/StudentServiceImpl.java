/**
 * @(#)StudentServiceImpl.java
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
package com.sagacstech.interview.prithvi.services.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagacstech.interview.prithvi.services.interfaces.IStudentDao;
import com.sagacstech.interview.prithvi.services.interfaces.IStudentService;
import com.sagacstech.interview.prithvi.services.models.Student;

/**
 * The service that exposes Crud operations of a student.
 * There is no need of any transactions as it doesn't work with mongo db
 * @author Prithvi
 *
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	/**
	 * Auto wire the student dao
	 */
	@Autowired
	private IStudentDao studentDao;
	
	/**
	 * Create a student. If created, sets the id and unique id on to the object
	 */
	@Override
	public void create(Student entity) throws Exception {
		logger.debug("Create Student");
		studentDao.create(entity);
	}

	/**
	 * Read a student based on the id
	 */
	@Override
	public Student read(String id) throws Exception {
		logger.debug("Read Student Id {}",id);
		return studentDao.read(id);
	}
	
	/**
	 * Read a student based on the unique id
	 */
	@Override
	public Student readByUniqueId(String uniqueId) throws Exception {
		logger.debug("Read Student unique Id {}",uniqueId);
		return studentDao.readByUniqueId(uniqueId);
	}
	
	/**
	 * Update the student
	 */
	@Override
	public void update(Student entity) throws Exception {
		logger.debug("Update Student");
		studentDao.update(entity);
	}

	/**
	 * Delete a student
	 */
	@Override
	public boolean delete(Student entity) throws Exception {
		logger.debug("Delete Student");
		return studentDao.delete(entity);
	}

	@Override
	public List<Student> fetch(Map<String, Object> filter, int limitCount)
			throws Exception {
		logger.debug("Fetch Students");
		return studentDao.fetch(filter, limitCount);
	}

}
