/**
 * @(#)StartupServlet.java
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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sagacstech.interview.prithvi.web.interfaces.IServlet;


/**
 * Servlet implementation class StartupServlet - Usually load cache etc
 */
@WebServlet(value="/startup", loadOnStartup=1)
public class StartupServlet extends ServletBase implements IServlet{
	
	private Logger log = LoggerFactory.getLogger(StartupServlet.class); 
	
	public StartupServlet() {
		super();
	}

	private static final long serialVersionUID = 1L;

	
	public void init(ServletConfig config) throws ServletException {
		log.info("Starting app");
	}

	public void destroy() {
		// Write some code on app unload if any
	}
}
