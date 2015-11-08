/**
 * 
 */
package com.dev.persistence;

import com.dev.persistence.model.Product;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class ProductImplDAO extends HibernateDAO<Product, Long> implements ProductDAO {

	public ProductImplDAO() {
		super(Product.class);
	}

}