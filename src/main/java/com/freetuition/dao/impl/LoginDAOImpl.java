package com.freetuition.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;
import com.freetuition.util.HibernateSessionFactory;

public class LoginDAOImpl {
	
	
	// --------------------------------------Customer Log In


	

	public Login letEmployeeLogin(String login, String password) throws BusinessException {
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
		}catch(HibernateException e) { ///add NoResultException
			System.out.print(e);
//			e.printStackTrace();
			tx.rollback();
			throw new BusinessException ("Wrong Login or Password");
		}finally {
			s.close();
		}
		return lg;
	}


}
