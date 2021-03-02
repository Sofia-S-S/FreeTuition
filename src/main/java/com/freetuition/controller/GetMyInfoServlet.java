package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;

/**
 * Servlet implementation class GetMyInfoServlet
 */
@WebServlet("/GetMyInfoServlet")
public class GetMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeDAOImpl dao = new EmployeeDAOImpl();
		
		
		
		
		Integer x = (Integer) request.getSession(false).getAttribute("userId");
		if (x!=null) {
			System.out.println("yes");

		System.out.println(x);
		
		try {
			Employee emp = dao.getEmployeeById(x);

		response.setContentType("application/json");
//		
//		Employee manager = new Employee();
//		Employee emp = new Employee(1,"Jessica","Brown","West Loop","engeneer",manager,"jess@west.com",875675588L,"6789 N Green St");
//		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String JSON = objectMapper.writeValueAsString(emp);
		
		response.getWriter().write(JSON);
		
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
			System.out.print("no");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
