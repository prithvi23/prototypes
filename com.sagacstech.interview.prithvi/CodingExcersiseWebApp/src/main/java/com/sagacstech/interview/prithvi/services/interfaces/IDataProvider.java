/**
 * @(#)IDataProvider.java
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

/**
 * Basic Crud operations
 * @author Prithvi
 *
 * @param <E>
 */
public interface IDataProvider<E extends IEntity> extends Serializable {
	
	// Basic Crud operations
	/**
	 * Read
	 * @param id
	 * @return
	 * @throws Exception
	 */
	E read(String id) throws Exception;
	
	/**
	 * Read by unique id managed by app not Mongo
	 * @param uniqueId
	 * @return
	 * @throws Exception
	 */
	E readByUniqueId(String uniqueId) throws Exception;
	/**
	 * Create
	 * @param entity
	 * @throws Exception
	 */
	void create(E entity) throws Exception;
	/**
	 * Update
	 * @param entity
	 * @throws Exception
	 */
	void update(E entity) throws Exception;
	/**
	 * Delete
	 * @param entity
	 * @throws Exception
	 */
	boolean delete(E entity) throws Exception;
	/**
	 * Fetch
	 * @param filter
	 * @param limitCount
	 * @return
	 * @throws Exception
	 */
	List<E> fetch(Map<String,Object> filter, int limitCount)  throws Exception;
}