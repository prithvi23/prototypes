/**
 * @(#)IStudentService.java
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
package com.sagacstech.interview.prithvi.services.interfaces;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.sagacstech.interview.prithvi.services.models.Student;

/**
 * Basic Crud operations
 * @author Prithvi
 *
 */
public interface IStudentService extends Serializable{
	/**
	 * Create
	 * @param entity
	 * @throws Exception
	 */
	void create(Student entity) throws Exception;
	/**
	 * Update
	 * @param entity
	 * @throws Exception
	 */
	void update(Student entity) throws Exception;
	/**
	 * Delete
	 * @param entity
	 * @throws Exception
	 */
	boolean delete(Student entity) throws Exception;
	/**
	 * Read
	 * @param id
	 * @return
	 * @throws Exception
	 */
	Student read(String id) throws Exception;
	
	/**
	 * Read
	 * @param uniqueId
	 * @return
	 * @throws Exception
	 */
	Student readByUniqueId(String uniqueId) throws Exception;
	
	/**
	 * Fetch
	 * @param filter
	 * @param limitCount
	 * @return
	 * @throws Exception
	 */
	List<Student> fetch(Map<String,Object> filter, int limitCount)  throws Exception;
}
