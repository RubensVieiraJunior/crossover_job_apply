/**
 * 
 */
package com.dev.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public abstract class HibernateDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {

	private Class<T> persistentClass;

	public HibernateDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public void beginTransaction() {
		HibernateUtil.beginTransaction();
	}

	public void commitTransaction() {
		HibernateUtil.commitTransaction();
	}
	
	public void rollbackTransaction() {
		HibernateUtil.rollbackTransaction();
	}

	public void save(T obj) {
		HibernateUtil.getSession().saveOrUpdate(obj);
	}

	public void refresh(T obj) {
		HibernateUtil.getSession().refresh(obj);
	}

	public void delete(T obj) {
		HibernateUtil.getSession().delete(obj);
	}

	@SuppressWarnings("unchecked")
	public T findById(Serializable id) {
		return (T) HibernateUtil.getSession().get(persistentClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = HibernateUtil.getSession();
		Criteria criteria = session.createCriteria(persistentClass);
		return criteria.list();
	}

}
