/**
 * 
 */
package com.dev.persistence.dao;

import org.hibernate.Session;

import com.dev.persistence.HibernateDAO;
import com.dev.persistence.HibernateUtil;
import com.dev.persistence.model.Customer;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class CustomerImplDAO extends HibernateDAO<Customer, Long> implements CustomerDAO {

	public CustomerImplDAO() {
		super(Customer.class);
	}

	/* (non-Javadoc)
	 * @see com.dev.persistence.GenericDAO#findByCode(java.lang.String)
	 */
	@Override
	public Customer findByCode(String code) {
		Session session = HibernateUtil.getSession();
		Customer entity = (Customer) session
				.createQuery("select e from Customer as e where e.cusCode = :code")
				.setString("code", code)
				.uniqueResult();
		return entity;
	}

}
