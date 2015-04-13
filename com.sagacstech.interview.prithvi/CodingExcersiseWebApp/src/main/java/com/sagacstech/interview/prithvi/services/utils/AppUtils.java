/**
 * @(#)AppUtils.java
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
package com.sagacstech.interview.prithvi.services.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Generic Utils
 * @author Prithvi
 *
 */
public final class AppUtils {
	private static final String SUCCESSFULLY_COMPLETED_YOUR_REQUEST = "Successfully completed your request";
	private static final String MESSAGE = "Message";
	private static final String SUCCESS = "Success";
	public static final String PERIOD = ".";
	public static final String EMAIL = "@sagacstech.com";
	public static final String PHONE = "55512345";

	private AppUtils(){}
	
	/**
	 * Returns a String Random id with a Character in the front
	 * @return
	 */
	public static String getRandomId() {
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		sb.append((char) (r.nextInt(26) + (byte) 'a'));
		sb.append((new Date()).getTime());
		return sb.toString();
	}
	
	private static Map<String,String> getResultMap(String success,String message){
		Map<String,String> resultMap = new HashMap<>();
		resultMap.put(SUCCESS, success);
		resultMap.put(MESSAGE, message);
		return resultMap;
	}
	
	/**
	 * Simply joins all Strings and returns
	 * 
	 * @param params
	 * @return
	 */
	public static String join(Object... params) {
		// Could have simply used StringUtils.join - but it needs you to declare
		// an array....
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < params.length; i++) {
			if (null != params[i]) {
				sb.append(params[i]);
			}
		}
		return sb.toString();
	}
	
	public static Map<String,String> getSuccessResult(){
		return getResultMap(Boolean.TRUE.toString(),SUCCESSFULLY_COMPLETED_YOUR_REQUEST);
	}
	
	public static Map<String,String> getFailureResult(String message){
		return getResultMap(Boolean.FALSE.toString(),message);
	}
}
