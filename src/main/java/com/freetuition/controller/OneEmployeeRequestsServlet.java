package com.freetuition.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.dao.impl.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Request;

/**
 * Servlet implementation class OneEmployeeRequestsServlet
 */
@WebServlet("/OneEmployeeRequestsServlet")
public class OneEmployeeRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneEmployeeRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        
		        
				System.out.println("We got here");
				int id = (int) request.getAttribute("id"); // retrieve employee id from request
				System.out.println(id);
		 	   //Get requests for this employee
		 	   RequestDAOImpl daoR = new RequestDAOImpl();
		 	   try {
				List<Request> reqList = daoR.getAllReqByEmployee(id);
				
				//Map List to JSON
				ObjectMapper objectMapper = new ObjectMapper();
				
				final String JSON = objectMapper.writeValueAsString(reqList);
				
				response.getWriter().write(JSON);
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Read inputs
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
    	System.out.println(firstName);
    	System.out.println(lastName);
        //Find employee
        EmployeeDAOImpl dao = new EmployeeDAOImpl();
        try {
			Employee employee = dao.getEmployeeByName(firstName, lastName);
			System.out.println(employee);
			
		//Check manager id
	       int manId = (Integer) request.getSession(false).getAttribute("userId");
	       if (manId == employee.getManager()) {
	    	   
	    	   //forward to the page with requests
	    	   request.setAttribute("id", employee.getId()); //pass employee id with request
	    		System.out.println(employee.getId());
	    	   request.getRequestDispatcher("pages/one-employee-req.html").forward(request, response);
	    	   

	       } else   request.getRequestDispatcher("ooops.html").forward(request, response);
			
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}}
