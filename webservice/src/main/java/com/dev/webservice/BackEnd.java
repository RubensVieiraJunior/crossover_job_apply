/**
 * 
 */
package com.dev.webservice;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.persistence.dao.CustomerDAO;
import com.dev.persistence.dao.CustomerImplDAO;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class BackEnd {

	Logger logger = LoggerFactory.getLogger(BackEnd.class);
	
	public String save(int objectType, String jsonObject) {
		String METHOD = "save(String jsonObject) ";
		
		logger.debug(METHOD + "Param:" + jsonObject);
		
		JSONObject jsObject = new JSONObject();
		
		
		CustomerDAO customerDao = new CustomerImplDAO();
		customerDao.beginTransaction();
		
		return "save";
	}
}
