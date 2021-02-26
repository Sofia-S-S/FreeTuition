package com.freetuition.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;
import com.freetuition.util.HibernateSessionFactory;

public class LoginDAOImpl {
	// --------------------------------------Customer Log In
	// -------------------------------------

	
//CHANGE TO LOGIN AND PASSWORD	
	public Login letEmployeeLogin(String login, String password) throws BusinessException, ClassNotFoundException  {
		Login lg= null;
	
		
		Session s = null;
		Transaction tx = null;
		
		try {
			s = HibernateSessionFactory.getSession();
			tx = s.beginTransaction();
			//-------------------------------------
			

			lg = s.createQuery("FROM Login WHERE login = :login AND password = :password",Login.class).setParameter("login", login).setParameter("password",password).getSingleResult();
			
			
			
//			lg = s.get(Login.class,login); //will return null if there is not any// always runs to db
//			c = s.load(Card.class, id); // will throw exception if not any // looks in proxies // need to comment out commit and close
			//-------------------------------------
			
			
			
			tx.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			s.close();
		}
		return lg;
	}


}
