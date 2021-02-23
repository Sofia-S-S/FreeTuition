package com.freetuition.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freetuition.model.Request;
import com.freetuition.util.HibernateSessionFactory;

public class RequestRepo {
	
	public List<Request> findAll() {
		List<Request> reqs = new ArrayList<>();
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			/*
			 * Hibernate has its own query language called "HQL" - Hibernate
			 * Query Language. HQL allows us to emphasize our Java models rather
			 * than the entities in the DB. It provides a more object-oriented
			 * approach to data persistence.
			 */
			reqs = s.createQuery("FROM Request", Request.class).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return reqs;
	}
	
	public void insert(Request r) {
		//All of our work is done within the context of a Hibernate session
		Session s = null;
		/*
		 * The Transaction interface gives you control over your DB transactions.
		 * You can use it to rollback changes, commit changes, and begin
		 * transactions.
		 */
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			/*
			 * This method persists the card (i.e. creates a new record
			 * in the table).
			 */
			s.save(r);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//Always close your sessions!
			s.close();
		}
	}

}
