/**
 * @(#)JsonUtils.java
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
package com.sagacstech.interview.prithvi.web.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * Json marshall,unmarshall
 * @author Prithvi
 *
 */
public class JsonUtils {

	/**
	 * Need an Object mapper
	 */
	private static ObjectMapper mapper = null;
	
	/**
	 * Static constructor
	 */
	static{
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

	/**
	 * Unmarshall Json to Object
	 * @param json
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T unmarshall(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(json, clazz);
	}

	/**
	 * Convert Object to Json
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String marshall(Object obj) throws JsonProcessingException {
		mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		return mapper.writeValueAsString(obj);
		
	}
	
	/**
	 * Extended version
	 * @param json
	 * @param typeReference
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T unmarshall(String json, TypeReference typeReference) throws JsonParseException, JsonMappingException, IOException{
		return mapper.readValue(json, typeReference);
	}
	
//	public static void main(String[] args) throws JsonProcessingException{
//		LogMessage vm = new LogMessage(MessageLevel.INFO, "JC1235", Strings.EMPTY, null, MessageCategory.EXCEL_ONLY);
//		System.out.println(marshall(vm));
//	}
}
