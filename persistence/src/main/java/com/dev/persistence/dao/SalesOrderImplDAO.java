/**
 * 
 */
package com.dev.persistence.dao;

import org.hibernate.Session;

import com.dev.persistence.HibernateDAO;
import com.dev.persistence.HibernateUtil;
import com.dev.persistence.model.SalesOrder;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class SalesOrderImplDAO extends HibernateDAO<SalesOrder, Long> implements SalesOrderDAO {

	public SalesOrderImplDAO() {
		super(SalesOrder.class);
	}

	/* (non-Javadoc)
	 * @see com.dev.persistence.GenericDAO#findByCode(java.lang.String)
	 */
	@Override
	public SalesOrder findByCode(String code) {
		Session session = HibernateUtil.getSession();
		SalesOrder entity = (SalesOrder) session
				.createQuery("select e from SalesOrder as e where e.sorOrderNum = :code")
				.setString("code", code)
				.uniqueResult();
		return entity;
	}

}
