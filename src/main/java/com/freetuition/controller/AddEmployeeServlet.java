package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;


@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
//	public static final Logger log = LogManager.getFormatterLogger(AddEmployeeServlet.class); // v2 set up
       

    public AddEmployeeServlet() {   super();   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
		
		//For Employee
    	int id = 7;
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        String email = request.getParameter("email");
        long contact = Long.parseLong(request.getParameter("contact"));
        String address = request.getParameter("address");
        int managerId = (int) request.getSession(false).getAttribute("userId");
        //For Login
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        
  
    	Employee employee = new Employee(id,first,last,company,position,managerId,email,contact,address);



        Login lgn = new Login(id,login,password);

        
        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        
       try {
		dao.createEmployee(employee, lgn);
	} catch (BusinessException e) {
		request.getRequestDispatcher("ooops.html").forward(request, response);

	}
		 request.getRequestDispatcher("pages/manager-home-page.html").forward(request, response);
    }
	

}
