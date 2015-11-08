/**
 * 
 */
package com.dev.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.persistence.CustomerDAO;
import com.dev.persistence.CustomerImplDAO;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class BackEnd {

	Logger logger = LoggerFactory.getLogger(BackEnd.class);
	
	public String save(String jsonObject) {
		String METHOD = "save(String jsonObject) ";
		
		logger.debug(METHOD + "Param:" + jsonObject);
		
		CustomerDAO customerDao = new CustomerImplDAO();
		customerDao.beginTransaction();
		
		return "save";
	}
}
