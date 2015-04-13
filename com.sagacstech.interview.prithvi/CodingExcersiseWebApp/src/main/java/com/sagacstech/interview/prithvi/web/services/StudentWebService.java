/**
 * @(#)StudentWebService.java
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
package com.sagacstech.interview.prithvi.web.services;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sagacstech.interview.prithvi.services.interfaces.IStudentService;
import com.sagacstech.interview.prithvi.services.models.Student;
import com.sagacstech.interview.prithvi.services.utils.AppUtils;

/**
 * 
 * @author Prithvi
 * Jersey based Student Crud web service
 */
@Path("/students")
@Component
public class StudentWebService implements Serializable{
	
	private static final String STUDENT_NOT_FOUND = "Student not found";

	private static final long serialVersionUID = 1L;

	private Logger log = LoggerFactory.getLogger(StudentWebService.class); 
	
	/**
	 * The Service that exposes the Crud operations
	 */
	@Autowired
	private IStudentService studentService;

	/**
	 * Create operation
	 * @param student
	 * @return
	 */
	@POST
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Map<String,String> create(Student student) {
		log.debug("Create WS Call {}",student);
		try {
			studentService.create(student);
		} catch (Exception e) {
			log.error("Error {}",e);
			return AppUtils.getFailureResult(e.getMessage());
		}
		return AppUtils.getSuccessResult();
	}
	
	/**
	 * Get Student
	 * @param limit
	 * @return
	 */
	@GET
	@Path("/list/{limit}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> get(@PathParam("limit") int limit ){
		log.debug("Get WS Call");
		try {
			return studentService.fetch(new HashMap<String,Object>(), limit);
		} catch (Exception e) {
			log.error("Error {}",e);
			return Collections.emptyList();
		}
	}
	
	/**
	 * Get a student by Id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student get(@PathParam("id") String id ){
		log.debug("Get WS Call");
		try {
			return studentService.read(id);
		} catch (Exception e) {
			log.error("Error {}",e);
			return null;
		}
	}
	
	/**
	 * Delete a student
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String>  delete(@PathParam("id") String id ){
		log.debug("Get WS Call");
		try {
			Student student = studentService.read(id);
			if (student != null){
				studentService.delete(student);
				return AppUtils.getSuccessResult();
			}
			return AppUtils.getFailureResult(STUDENT_NOT_FOUND);
		} catch (Exception e) {
			log.error("Error {}",e);
			return AppUtils.getFailureResult(e.getMessage());
		}
	}
}
