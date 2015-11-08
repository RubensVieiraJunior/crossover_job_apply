/**
 * 
 */
package com.dev.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public interface GenericDAO<T, Type extends Serializable> {

	public void beginTransaction();

	public void commitTransaction();
	
	public void rollbackTransaction();

	public void save(T entity);

	public void delete(T entity);

	public T findById(Serializable id);

	public List<T> findAll();
}
