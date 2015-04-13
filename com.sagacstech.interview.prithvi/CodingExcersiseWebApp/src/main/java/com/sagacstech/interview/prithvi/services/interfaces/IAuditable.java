/**
 * @(#)IAuditable.java
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

/**
 * By default most objects are auditiable
 * @author Prithvi
 *
 */
public interface IAuditable extends IEntity {

	/**
	 * Gets created date time
	 * @return
	 */
	long getCreatedDtm();

	/**
	 * Set Created date time
	 * @param createdDtm
	 */
	void setCreatedDtm(long createdDtm);

	/**
	 * Get Created by
	 * @return
	 */
	long getCreatedBy();

	/**
	 * Set created by
	 * @param createdBy
	 */
	void setCreatedBy(long createdBy);

	/**
	 * Get updated date time
	 * @return
	 */
	long getUpdatedDtm();

	/**
	 * Set updated date time
	 * @param updatedDtm
	 */
	void setUpdatedDtm(long updatedDtm);

	/**
	 * Get updated by
	 * @return
	 */
	long getUpdatedBy();

	/**
	 * Set updated by
	 * @param updatedBy
	 */
	void setUpdatedBy(long updatedBy);
}
