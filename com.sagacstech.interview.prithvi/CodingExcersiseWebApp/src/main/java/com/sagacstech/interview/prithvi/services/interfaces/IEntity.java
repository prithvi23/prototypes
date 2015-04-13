/**
 * @(#)IEntity.java
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

/**
 * All entities - the models or the pojos
 * @author Prithvi
 *
 */
public interface IEntity extends Serializable{

	/**
	 * Returns the id
	 * @return
	 */
	String get_id();

	/**
	 * Set id
	 * @param id
	 */
	void set_id(String id);
	
	/**
	 * Returns if new or not
	 * @return
	 */
	boolean isNew();
}
