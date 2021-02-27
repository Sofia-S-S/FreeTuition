package com.freetuition.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
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
	
	// Get Employee by Id
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
	
	// Get Employee by Id
	public Employee getEmployeeByName(String firstName, String lastName) throws BusinessException {
		
		Employee employee= null;
	
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			//-------------------------------------
			

			employee = s.createQuery("FROM Employee WHERE firstName = :firstName AND lastName = :lastName ",Employee.class).setParameter("firstName", firstName).setParameter("lastName", lastName).getSingleResult();
			

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
	
	
	
	
}
