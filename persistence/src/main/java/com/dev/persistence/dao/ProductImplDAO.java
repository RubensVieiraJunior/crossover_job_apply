/**
 * 
 */
package com.dev.persistence.dao;

import org.hibernate.Session;

import com.dev.persistence.HibernateDAO;
import com.dev.persistence.HibernateUtil;
import com.dev.persistence.model.Product;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class ProductImplDAO extends HibernateDAO<Product, Long> implements ProductDAO {

	public ProductImplDAO() {
		super(Product.class);
	}

	/* (non-Javadoc)
	 * @see com.dev.persistence.GenericDAO#findByCode(java.lang.String)
	 */
	@Override
	public Product findByCode(String code) {
		Session session = HibernateUtil.getSession();
		Product entity = (Product) session
				.createQuery("select e from Product as e where e.cusCode = :code")
				.setString("code", code)
				.uniqueResult();
		return entity;
	}

}
