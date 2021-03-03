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
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;

/**
 * Servlet implementation class AllEmployeesServlet
 */
@WebServlet("/AllEmployeesServlet")
public class AllEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	    EmployeeDAOImpl repo = new EmployeeDAOImpl();
		
		response.setContentType("application/json");

		
		List<Employee> employees;
		try {
			employees = repo.getAllEmployees();
			
//			List<Employee> newList = null;
			
//			for (Employee em: employees) {
//			em.getManager().setId(0);
//			}
			
			
//			Employee manager = new Employee();
//			manager.setFirstName("Bob");
//			manager.setId(3);
//			manager.setLastName("Burger");
//			
//			employees = Arrays.asList((new Employee(7,"Natasha","Brick","West","CEO",manager,"tasha@west.com",888776647,"377 W Green St")),
//					new Employee(9,"Natasha","Brick","West","CEO",manager,"tasha@west.com",888776647,"377 W Green St"));

		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String JSON = objectMapper.writeValueAsString(employees);
		
		response.getWriter().write(JSON);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
