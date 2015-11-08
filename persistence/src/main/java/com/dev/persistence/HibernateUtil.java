/**
 * 
 */
package com.dev.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Rubens Luiz Vieira Junior
 *
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();

	private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();

	static {
		Configuration cfg = new Configuration().configure();

		sessionFactory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		Session session = threadSession.get();
		try {
			if (session == null) {
				session = sessionFactory.openSession();
				threadSession.set(session);
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
		return session;
	}

	public static void closeSession() {
		try {
			Session session = threadSession.get();
			threadSession.set(null);
			if (session != null && session.isOpen()) {
				session.close();
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public static void beginTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction == null) {
				transaction = getSession().beginTransaction();
				threadTransaction.set(transaction);
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		}
	}

	public static void commitTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack()) {
				transaction.commit();
			}
			
			threadTransaction.set(null);
		} catch (HibernateException ex) {
			rollbackTransaction();
			ex.printStackTrace();
		}
	}

	public static void rollbackTransaction() {
		Transaction transaction = threadTransaction.get();
		try {
			threadTransaction.set(null);
			if (transaction != null && !transaction.wasCommitted() && !transaction.wasRolledBack()) {
				transaction.rollback();
			}
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			closeSession();
		}
	}
}
