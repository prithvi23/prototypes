/**
 * @(#)EntityBase.java
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

import org.jongo.marshall.jackson.oid.Id;
import org.jongo.marshall.jackson.oid.ObjectId;
import org.springframework.util.StringUtils;


/**
 * 
 * @author Prithvi
 * Base class for all entities
 *
 */
public abstract class EntityBase{
	
	/**
	 * Jongo uses this annotation
	 */
	@ObjectId
	@Id
	private String _id;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	public boolean isNew(){
		return StringUtils.isEmpty(_id);
	}

}