/**
 * @(#)ServletBase.java
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
package com.sagacstech.interview.prithvi.web.servlets;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author Prithvi
 * This is for all non spring servlets
 *
 */
public abstract class ServletBase extends HttpServlet implements ApplicationContextAware{

	private static final long serialVersionUID = 1L;
	protected WebApplicationContext webApplicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		webApplicationContext = (WebApplicationContext) applicationContext;
	}
	
	protected Object getBean(String beanName, ServletContext sc){
		if (webApplicationContext == null) {
			System.out.println("setting context in getBean");
			webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sc);
		}
		return webApplicationContext.getBean(beanName);
	}

}
