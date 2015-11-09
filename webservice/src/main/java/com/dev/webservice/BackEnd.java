/**
 * 
 */
package com.dev.webservice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dev.persistence.GenericDAO;
import com.dev.persistence.dao.CustomerImplDAO;
import com.dev.persistence.dao.ProductImplDAO;
import com.dev.persistence.dao.SalesOrderImplDAO;
import com.dev.persistence.model.Customer;
import com.dev.persistence.model.Product;
import com.dev.persistence.model.SalesOrder;
import com.google.gson.Gson;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class BackEnd {

	Logger logger = LoggerFactory.getLogger(BackEnd.class);
	
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String save(String jsonObject, int objectType) throws Exception {
		String METHOD = "save(String jsonObject, int objectType) ";
		
		logger.info(METHOD + "Param[0]:" + jsonObject + "_Param[1]:" + objectType);
		
		Gson gson = new Gson();
		Map mapObject = gson.fromJson(jsonObject, Map.class);
		
		GenericDAO dao = null;
		Object entity = null;
		switch (objectType) {
		case TYPE_PRODUCT:
			dao = new ProductImplDAO();
			Product prd = new Product();
			prd.setPrdCode((String) mapObject.get("code"));
			prd.setPrdCode((String) mapObject.get("code"));
			prd.setPrdDescription((String) mapObject.get("description"));
			prd.setPrdPrice(new BigDecimal((String) mapObject.get("price")));
			prd.setPrdQuantity(new Integer((String) mapObject.get("quantity")));
			
			entity = prd;
			
			break;

		case TYPE_CUSTOMER:
			dao = new CustomerImplDAO();
			Customer cus = new Customer();
			cus.setCusCode((String) mapObject.get("code"));
			cus.setCusName((String) mapObject.get("name"));
			cus.setCusAddress((String) mapObject.get("address"));
			cus.setCusPhone1((String) mapObject.get("phone1"));
			cus.setCusPhone2((String) mapObject.get("phone2"));
			cus.setCusCreditLimit(new BigDecimal((String)mapObject.get("creditLimit")));
			cus.setCusCurrentCredit(new BigDecimal((String) mapObject.get("currentCredit")));
			
			entity = cus;
			
			break;

		case TYPE_SALESORDER:
			dao = new SalesOrderImplDAO();
			SalesOrder sor = new SalesOrder();
			Map mapCustomer = (Map) mapObject.get("customer");
			
			sor.setSorOrderNum((String) mapObject.get("orderNum"));
			sor.setSorTotalPrice(new BigDecimal((String) mapObject.get("totalPrice")));
			sor.setSorCusId((Long) mapCustomer.get("code"));
//			JSONArray jsOrderLines = (JSONArray) mapObject.get("orderLines");
			
			entity = sor;
			
			break;

		default:
			break;
		}
		
		dao.beginTransaction();
		
		dao.save(entity);
		
		dao.commitTransaction();
		
		return gson.toJson(mapObject);
	}
	
	@SuppressWarnings("rawtypes")
	public String readRecordByCode(String code, int objectType) {
		String METHOD = "readRecordByCode(String code, int objectType) ";
		
		logger.info(METHOD + "Param[0]:" + code + "_Param[1]:" + objectType);
		
		GenericDAO dao = null;
		Object entity = null;
		switch (objectType) {
		case TYPE_PRODUCT:
			dao = new ProductImplDAO();
			
			break;

		case TYPE_CUSTOMER:
			dao = new CustomerImplDAO();
			
			break;

		case TYPE_SALESORDER:
			dao = new SalesOrderImplDAO();
			
			break;

		default:
			break;
		}
		
		dao.beginTransaction();
		
		entity = dao.findByCode(code);
		if (entity != null) {
			Gson gson = new Gson();
			return gson.toJson(entity);
		} else {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean deleteRecordByCode(String code, int objectType) throws Exception {
		String METHOD = "deleteRecordByCode(String code, int objectType) ";
		
		logger.info(METHOD + "Param[0]:" + code + "_Param[1]:" + objectType);
		
		GenericDAO dao = null;
		Object entity = null;
		switch (objectType) {
		case TYPE_PRODUCT:
			dao = new ProductImplDAO();
			
			break;

		case TYPE_CUSTOMER:
			dao = new CustomerImplDAO();
			
			break;

		case TYPE_SALESORDER:
			dao = new SalesOrderImplDAO();
			
			break;

		default:
			break;
		}
		
		dao.beginTransaction();
		
		entity = dao.findByCode(code);
		if (entity != null) {
			dao.delete(entity);
			dao.commitTransaction();
			
			return true;
		} else {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String listCurrentRecords(int objectType) {
		String METHOD = "listCurrentRecords(int objectType) ";
		
		logger.info(METHOD + "Param[0]:" + objectType);
		
		GenericDAO dao = null;
		switch (objectType) {
		case TYPE_PRODUCT:
			dao = new ProductImplDAO();
			
			break;

		case TYPE_CUSTOMER:
			dao = new CustomerImplDAO();
			
			break;

		case TYPE_SALESORDER:
			dao = new SalesOrderImplDAO();
			
			break;

		default:
			break;
		}
		
		dao.beginTransaction();
		
		List<Object> lstEntity = dao.findAll();
		Gson gson = new Gson();
		return gson.toJson(lstEntity);
	}
	
}
