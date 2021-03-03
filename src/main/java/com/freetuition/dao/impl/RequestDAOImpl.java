package com.freetuition.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Request;
import com.freetuition.util.HibernateSessionFactory;

public class RequestDAOImpl {
	
	// ---------------------- All requests by Status
	
	public List<Request> getAllReqsForManager(int manId , String status) throws BusinessException {
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
			reqs = s.createQuery("FROM Request r WHERE r.manager.id = :manId AND r.status = :status", Request.class).setParameter("manId", manId).setParameter("status",status).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			throw new BusinessException("No requests found");
		}finally {
			s.close();
		}
		
		return reqs;
	}
	
	//-------------- All Requests from one Employee ----------------------------------------
	
	public List<Request> getAllReqByEmployee(int employee) throws BusinessException {
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
			reqs = s.createQuery("FROM Request r WHERE r.employee.id = :employee", Request.class).setParameter("employee",employee).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return reqs;
	}
	//-------------- All Requests from one Employee By Manager ----------------------------------------
	
	public List<Request> getAllReqByEmployee(int employeeId, int managerId) throws BusinessException {
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
			reqs = s.createQuery("FROM Request r WHERE r.employee.id = :employeeId AND r.manager.id = :managerId", Request.class).setParameter("employeeId",employeeId).setParameter("managerId", managerId).getResultList();
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		
		return reqs;
	}
	//-------------------------Add Request
	
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
	
	//---------------------Approve Request (Status = > Approved)
	
	public void approveRequest(Request req) {
		
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
	
			s.update(req);
			
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//Always close your sessions!
			s.close();
		}
	}
	
	public Request getRequestById(int id) {
		Request c= null;
	
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			//-------------------------------------
			
			c = s.get(Request.class, id); //will return null if there is not any// always runs to db
//			c = s.load(Request.class, id); // will throw exception if not any // looks in proxies // need to comment out commit and close
			//-------------------------------------
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return c;
	}
	
	//-----------------------------------------------------
	
	//-------------- All Requests  ----------------------------------------
	
	public List<Request> getAllRequests() throws BusinessException {
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

}
