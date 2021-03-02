package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.model.Employee;
import com.freetuition.model.Request;

/**
 * Servlet implementation class GetRequestServlet
 */
@WebServlet("/GetRequestServlet")
public class GetRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		RequesDAOImpl dao = new RequesDAOImpl();
//		Request req = dao.getRequestById
		Employee someone = new Employee();
		Employee employee = new Employee(7,"Natasha","Brick","West","Manager",someone,"tasha@west.com",888776647,"Home");
		Employee manager = new Employee(3,"Lui","Grog","West","Manager",someone,"lui@west.com",888776647,"Home");
		
		Request req = new Request(7, employee, "school", "course",800,"pending",null, manager, "pending");
	
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String JSON = objectMapper.writeValueAsString(req);
		
		response.getWriter().write(JSON);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
