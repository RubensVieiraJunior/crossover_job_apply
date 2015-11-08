/**
 * 
 */
package com.dev.persistence;

import com.dev.persistence.model.Customer;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class CustomerImplDAO extends HibernateDAO<Customer, Long> implements CustomerDAO {

	public CustomerImplDAO() {
		super(Customer.class);
	}

}
