package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.LoginDAOImpl;
import com.freetuition.exception.BusinessException;

import com.freetuition.model.Login;


public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.  
		try {
	    	
			//Get from user input
	        String login = request.getParameter("login");
	        String password = request.getParameter("password");
	        
	     
	        LoginDAOImpl dao = new LoginDAOImpl();
			
	        System.out.println(login);
	        System.out.println(password);
			Login user = dao.letEmployeeLogin(login, password); 
			System.out.print(user);
			
			
			
        if(user !=null)   //On success, you can forward user to Home page
        {
        	
        	request.getSession(true).setAttribute("userId", user.getId()); // Store id in request scope.
        	
  
        	System.out.print("Your id is: "+user.getId());

        	 
                 request.getRequestDispatcher("pages/employee-home-page.html").forward(request, response); // Forward to JSP page to display id in a HTML.
       		
              }

        else   //On Failure, display a meaningful message to the User.

        request.getRequestDispatcher("ooops.html").forward(request, response); // Forward to Oops Page

		} catch (BusinessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("ooops.html").forward(request, response); // Forward to Oops Page
		}
	}
}

