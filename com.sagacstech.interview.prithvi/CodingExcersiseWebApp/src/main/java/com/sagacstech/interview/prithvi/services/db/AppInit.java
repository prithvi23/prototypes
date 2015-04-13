/**
 * @(#)AppInit.java
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

import java.io.Serializable;
import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.jongo.marshall.jackson.JacksonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * The DB config - Jongo, DB
 * @author Prithvi
 *
 */
@Configuration
public class AppInit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Value("#{environment['app.db.name']}")
	private String appDbName;

	/**
	 * The db host
	 */
	@Value("#{environment['db.host']}")
	private String dbHost;

	/**
	 * The port
	 */
	@Value("#{environment['db.port']}")
	private String dbPort;

	private Jongo jongo = null;

	@Bean
	public DB getDb() throws Exception {
		return getConfig().getDB(appDbName);
	}

	@Bean
	public MongoClient getConfig() throws UnknownHostException {
		return new MongoClient(dbHost, Integer.parseInt(dbPort));
	}

	@Bean
	public Jongo getJongo() throws Exception {
		if (jongo == null) {
			this.jongo = new Jongo(getDb(), new JacksonMapper.Builder()
					.registerModule(new JodaModule())
					.enable(MapperFeature.AUTO_DETECT_GETTERS).build());
		}
		return jongo;
	}

}
