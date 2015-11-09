package com.dev.persistence.model;
// Generated 09/11/2015 04:32:00 by Hibernate Tools 3.5.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class SalesOrder.
 * @see com.dev.persistence.model.SalesOrder
 * @author Hibernate Tools
 */
public class SalesOrderHome {

	private static final Log log = LogFactory.getLog(SalesOrderHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SalesOrder transientInstance) {
		log.debug("persisting SalesOrder instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SalesOrder instance) {
		log.debug("attaching dirty SalesOrder instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SalesOrder instance) {
		log.debug("attaching clean SalesOrder instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SalesOrder persistentInstance) {
		log.debug("deleting SalesOrder instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SalesOrder merge(SalesOrder detachedInstance) {
		log.debug("merging SalesOrder instance");
		try {
			SalesOrder result = (SalesOrder) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SalesOrder findById(long id) {
		log.debug("getting SalesOrder instance with id: " + id);
		try {
			SalesOrder instance = (SalesOrder) sessionFactory.getCurrentSession()
					.get("com.dev.persistence.model.SalesOrder", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SalesOrder instance) {
		log.debug("finding SalesOrder instance by example");
		try {
			List results = sessionFactory.getCurrentSession().createCriteria("com.dev.persistence.model.SalesOrder")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
