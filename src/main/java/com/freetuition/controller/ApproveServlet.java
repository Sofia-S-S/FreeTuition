package com.freetuition.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RequestApproveServlet
 */
@WebServlet("/RequestApproveServlet")
public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Get everything for Updating request

    	int id = Integer.parseInt(request.getParameter("idA"));
       	int employee = Integer.parseInt(request.getParameter("emplA"));
       	String school = request.getParameter("schoolA");
       	String course = request.getParameter("courseA");
       	String type = request.getParameter("typeA");
       	double price = Double.parseDouble(request.getParameter("priceA"));
       	String status = "approved";
       	Date graduation = new Date();
       	String receipt = null;
       	Date date = new Date();
       	
		//Get everything for Approved request
       	//WORKING CODE UNCOMMENT LATER
//       	int manager = (Integer) request.getSession(false).getAttribute("userId");
       	int manager = 2;
       	double amount = Double.parseDouble(request.getParameter("amount"));
       	
//       	
//       	Request req = new Request(id,employee,school,course,type,price,status,graduation,receipt,date);
//       	RequestApproved approve = new RequestApproved(id,amount,manager,new Date());
//       	
//       	
//       RequestDAOImpl dao = new RequestDAOImpl();
//       dao.approveRequest(req, approve);
//       
       response.sendRedirect("pages/requests-pending.html");
	}

}
