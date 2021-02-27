package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.dao.LoginDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	//try code
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
       

     
        LoginDAOImpl dao = new LoginDAOImpl();
        EmployeeDAOImpl daoE = new  EmployeeDAOImpl();
        
       //The core Logic of the Registration application is present here. We are going to insert user data in to the database.  
		try {
			
	        System.out.println(login);
	        System.out.println(password);
			Login user = dao.letEmployeeLogin(login, password); 
			System.out.print(user);
			
			
			
        if(user !=null)   //On success, you can display a message to user on Home page
        {
        	
        	request.getSession(true).setAttribute("userId", user.getId());
        	
        	
        	
        	
//        	request.setAttribute("id", user.getId());
        	System.out.print("Your id is: "+user.getId());
//        	 EmployeeDAOImpl daoE = new EmployeeDAOImpl();	
//        	  Employee employee = daoE.getEmployeeById(123); // Obtain login info
//              if(employee !=null)   //On success, you can display a message to user on Home page
//              {
//            	  ObjectMapper map = new ObjectMapper();
//            	  final String JSON = map.writeValueAsString(employee);
//            	 response.setContentType("application/json");
//            	 response.getWriter().write(JSON);
//            	 
//            	 for JSPs
//               request.setAttribute("employeeId", user.getId()); // Store id in request scope.
//               request.setAttribute("name", employee.getFirstName());
            	 
                 request.getRequestDispatcher("pages/employee-home-page.html").forward(request, response); // Forward to JSP page to display id in a HTML.
       		
              }
//         request.setAttribute("userid", user.getId()); // Store id in request scope.
//           request.getRequestDispatcher("employee-home-page.jsp").forward(request, response); // Forward to JSP page to display id in a HTML.
//    		response.getWriter().write("Your id is "+user.getId());
//        }
//        else   //On Failure, display a meaningful message to the User.
//        {
//           request.setAttribute("errMessage", userRegistered);
//           request.getRequestDispatcher("/Register.jsp").forward(request, response);
//        }
		} catch (BusinessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

