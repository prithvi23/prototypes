/**
 * @(#)StudentDao.java
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jongo.Oid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;
import com.sagacstech.interview.prithvi.services.interfaces.IStudentDao;
import com.sagacstech.interview.prithvi.services.models.Student;
import com.sagacstech.interview.prithvi.services.utils.AppUtils;

/**
 * 
 * @author Prithvi
 * Student crud dao
 */
@Repository("studentDao")
public class StudentDao extends DataProvider<Student> implements  IStudentDao {

	private static final String HASHTAG = "#";
	
	private Logger logger = LoggerFactory.getLogger(StudentDao.class);


	public StudentDao(){
		super(Student.COLLECTION_NAME);
	}
	
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * Save or update. Inserts if not found, updates if found
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	private void save(Student entity) throws Exception {
		if (entity == null){
			return;
		}
		if (entity.isNew()){
			entity.setUniqueId(AppUtils.getRandomId());
			WriteResult res = getCollection().insert(entity);
		}else{
	        Student old = getCollection().findOne(Oid.withOid(entity.get_id())).as(Student.class);
			if (null != old){
				getCollection().save(entity);
			}
		}
	}

	/**
	 * Read implementation based on the id
	 */
	@Override
	public Student read(String id) throws Exception {
		return getCollection().findOne(Oid.withOid(id)).as(Student.class);
	}
	
	/**
	 * Read by unique id managed by app not Mongo
	 * @param uniqueId
	 * @return
	 * @throws Exception
	 */
	@Override
	public Student readByUniqueId(String uniqueId) throws Exception{
		logger.debug("ReadbyUniqueId {}",uniqueId);
		Student student = getCollection().findOne(UNIQUE_ID_FILTER,uniqueId).as(Student.class);
		return student;
	}
	
	/**
	 * Create operation based on passed entity. If created sets the id and unique id on to the object
	 */
	@Override
	public void create(Student entity) throws Exception {
		save(entity);
	}

	/**
	 * Updated all fields - using id
	 */
	@Override
	public void update(Student entity) throws Exception {
		save(entity);
	}

	/**
	 * Checks and deletes a student if present
	 */
	@Override
	public boolean delete(Student entity) throws Exception {
		String id = null;
		if (entity != null && !entity.isNew() && read(entity.get_id()) != null){
			id = entity.get_id();
			WriteResult res = getCollection().remove(Oid.withOid(id));
		}
		return read(id) == null;
	}
	
	/**
	 * Returns a few students 
	 */
	@Override
	public List<Student> fetch(Map<String,Object> filter, int limitCount)  throws Exception{
		// Filter not implemented
		Iterable<Student> studentsIter =  getCollection().find().limit(limitCount).as(Student.class);
		List<Student> studentsColl = new ArrayList<>();
		if (studentsIter != null){
			for (Student student : studentsIter){
				studentsColl.add(student);
			}
		}
		return studentsColl;
	}
}
