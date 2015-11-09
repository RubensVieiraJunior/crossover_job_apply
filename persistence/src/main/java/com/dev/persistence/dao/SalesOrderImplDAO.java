/**
 * 
 */
package com.dev.persistence.dao;

import com.dev.persistence.HibernateDAO;
import com.dev.persistence.model.SalesOrder;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class SalesOrderImplDAO extends HibernateDAO<SalesOrder, Long> implements SalesOrderDAO {

	public SalesOrderImplDAO() {
		super(SalesOrder.class);
	}

}
