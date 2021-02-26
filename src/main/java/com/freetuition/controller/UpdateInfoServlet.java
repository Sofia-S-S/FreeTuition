package com.freetuition.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.model.Employee;



public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateInfoServlet() {
        super();
    }
    
    EmployeeDAOImpl dao = new EmployeeDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	


    	int id = Integer.parseInt(request.getParameter("id"));
        String first = request.getParameter("firstName");
        String last = request.getParameter("lastName");
        String company = request.getParameter("company");
        String position = request.getParameter("position");
        String email = request.getParameter("email");
        long contact = Long.parseLong(request.getParameter("contact"));
        String address = request.getParameter("address");
        int managerId = Integer.parseInt(request.getParameter("managerId"));

        
    	Employee employee = new Employee(id,first,last,company,position,managerId,email,contact,address);
    	
    	dao.updateEmployee(employee);
		
		System.out.println(employee);
		
		 request.getRequestDispatcher("pages/employee-home-page.html").forward(request, response);
		


		
////		WRONG CODE
//		System.out.println("This is POST in update-info that is UpdateInfoServlet");	
//		System.out.println("do post" + response.toString());
//    	String s = response.toString();
//    	ObjectMapper objectMapper = new ObjectMapper();
//		Employee emp = objectMapper.readValue(s, Employee.class);
//		System.out.println(emp.getFirstName());
		 
		 //RIGHT CODE
	    	ObjectMapper objectMapper = new ObjectMapper();
			Employee emp = objectMapper.readValue(request.getInputStream(), Employee.class);
    	
		 

}}
