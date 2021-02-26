package com.freetuition.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.freetuition.dbutil.PostresqlConnection;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
import com.freetuition.model.Request;
import com.freetuition.model.RequestApproved;
import com.freetuition.model.RequestRejected;
import com.freetuition.util.HibernateSessionFactory;

public class EmployeeDAOImpl {

	// Create Employee // Create Login
	public void createEmployee(Employee employee, Login login) throws BusinessException {

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
			s.save(employee);
			s.save(login);
			tx.commit();

		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			throw new BusinessException("Something went wrong");

		}finally {
			//Always close your sessions!
			s.close();
		}

	}
	
	// Create Employee // Create Login
	public void updateEmployee(Employee employee) {
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
			s.update(employee);
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			//Always close your sessions!
			s.close();
		}
	}
	// Get Employee // Get his Manager Name
	public Employee getEmployeeById(int id) throws BusinessException {
		
		Employee employee= null;
	
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			//-------------------------------------
			

			employee = s.createQuery("FROM Employee WHERE id = :id",Employee.class).setParameter("id", id).getSingleResult();
			

			//-------------------------------------
			
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return employee;
	}
	
	
	//Create Request with status "open"
	public boolean createRequest() {
		return false;	
	}
	
	//Create ReimbursementApproved //Update status of Request to "approved"
	public boolean approveRequest() {
		return false;	
	}
	
	//Create ReimbursementRejected //Update status of Request to "rejected"
	public boolean rejectRequest() {
		return false;	
	}
	
	//Get All Requests join with Employee (Sort by employee or manager and status)
	public List<Request> getAllRequests() {
		return null;	
	}
	
	public Request getRequestById(int requestId) {
		return null;	
	}
	
	public RequestApproved getApprovedRequest (int  requestId) {
		return null;
		
	}
	public RequestRejected getRejectedRequest (int  requestId) {
		return null;
		
	}
	
}
