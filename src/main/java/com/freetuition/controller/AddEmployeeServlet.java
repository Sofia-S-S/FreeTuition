package com.freetuition.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
    	System.out.println(employee);


        Login lgn = new Login(id,login,password);
     	System.out.println(lgn);
        
        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        
       try {
		dao.createEmployee(employee, lgn);
	} catch (BusinessException e) {

	}
		 request.getRequestDispatcher("pages/manager-home-page.html").forward(request, response);
    }
	

}
