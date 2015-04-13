/**
 * @(#)Auditable.java
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

import java.util.Date;

/**
 * Base class of all auditable entities
 * @author Prithvi
 *
 */
public abstract class Auditable extends EntityBase {
	
	/**
	 * Created date time
	 */
	protected long createdDtm = (new Date()).getTime();
	/**
	 * Created by
	 */
	protected long createdBy;
	/**
	 * Updated date time
	 */
	protected long updatedDtm = (new Date()).getTime();
	/**
	 * Updated by
	 */
	protected long updatedBy;

	public long getCreatedDtm() {
		return createdDtm;
	}

	public void setCreatedDtm(long createdDtm) {
		this.createdDtm = createdDtm;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getUpdatedDtm() {
		return updatedDtm;
	}

	public void setUpdatedDtm(long updatedDtm) {
		this.updatedDtm = updatedDtm;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
