/**
 * @(#)DataProvider.java
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
package com.sagacstech.interview.prithvi.services.db;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.sagacstech.interview.prithvi.services.interfaces.IEntity;

/**
 * Core data provider with protected members
 * 
 * @author Prithvi
 *
 * @param <E>
 */
public abstract class DataProvider<E extends IEntity> {
	
	private MongoCollection mongoCollection;
	
	protected static final String UNIQUE_ID_FILTER = "{	uniqueId:#}";
	protected static final String ID_FILTER = "{id:#}";
	
	public DataProvider(String collectionName) {
		super();
		this.collectionName = collectionName;
	}
	
	private String collectionName;
	
	@Autowired
	protected MongoClient mongoClient;

	@Autowired
	protected DB db;

	@Autowired
	protected Jongo jongo;

	/**
	 * Get a collection with the given name, and store it, so that it will be
	 * dropped in clean up
	 * 
	 * @param name
	 *            The name of the collection
	 * @return The collection
	 * @throws Exception 
	 */
	protected MongoCollection getCollection() throws Exception {
		if (mongoCollection == null) {
			mongoCollection = jongo.getCollection(collectionName);
		}
		return mongoCollection;
	}
}