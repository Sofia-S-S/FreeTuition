package com.freetuition.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
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
		String type = request.getParameter("type");
		double price = Double.parseDouble(request.getParameter("price"));
		String status = "pending";
//		int managerId = Integer.parseInt(request.getParameter("managerId"));
//		Date graduation = null;
//		String receipt = null;
//		Date date = null;
		// For Login


		
		Request req = new Request(7, employeeId, school, course, type,price, status,new Date(),null, new Date());
		System.out.println(req);


		RequestDAOImpl dao = new RequestDAOImpl();

		dao.insert(req);
	}

}
