package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.EmployeeDAOImpl;
import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Request;

/**
 * Servlet implementation class NewRequestServlet
 */
@WebServlet("/NewRequestServlet")
public class NewRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Copying all the input parameters in to local variables

		
//FIX NULL POINTER EXEPTION
		int employeeId = (Integer) request.getSession(false).getAttribute("userId");
		
		
		String school = request.getParameter("school");
		String course = request.getParameter("course");
		double price = Double.parseDouble(request.getParameter("price"));
		
		
		//Get employee to Find manager 
		EmployeeDAOImpl daoE  = new EmployeeDAOImpl();
		try {
			Employee emp = daoE.getEmployeeById(employeeId);
			int managerId = emp.getManager().getId();
		
		Employee someone = new Employee();
		Employee employee = new Employee(employeeId,"x","x","x","x",someone,"x",1,"x");
		Employee manager = new Employee(managerId,"x","x","x","x",someone,"x",1,"x");
		
		Request req = new Request(1, employee, school, course, price,"pending",null, manager, "");
		System.out.println(req);


		RequestDAOImpl dao = new RequestDAOImpl();

		dao.insert(req);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 request.getRequestDispatcher("pages/employee-home-page.html").forward(request, response);
	}

}
