package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;
import com.freetuition.service.LoginService;
import com.freetuition.service.impl.LoginServiceImpl;

/**
 * Servlet implementation class ManagerLoginServlet
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerLoginServlet() {
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

		try {
			// Get from user input
			String login = request.getParameter("login");
			String password = request.getParameter("password");

			LoginService service = new LoginServiceImpl();

			Login user = service.letEmployeeLogin(login, password);

			if (user != null) // On success, you can forward user to Home page
			{
				//Check if this employee is a manager
				
				EmployeeDAOImpl daoE = new EmployeeDAOImpl();
				
				String position = daoE.getEmployeeById(user.getId()).getPosition();
				
				if (position.equals("Manager") || position.equals("General Manager") || position.equals("CEO") ) {

				request.getSession(true).setAttribute("userId", user.getId()); // Store id in request scope.

				System.out.print("Your id is: " + user.getId());

				request.getRequestDispatcher("pages/manager-home-page.html").forward(request, response); // Forward to home page
				}
				else // On Failure, display a meaningful message to the User.

					request.getRequestDispatcher("ooops.html").forward(request, response); // Forward to Oops Page																					
			}

			else // On Failure, display a meaningful message to the User.

				request.getRequestDispatcher("ooops.html").forward(request, response); // Forward to Oops Page

		} catch (BusinessException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("ooops.html").forward(request, response); // Forward to Oops Page
		}
	}

}
