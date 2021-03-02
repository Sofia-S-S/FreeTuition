package com.freetuition.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.model.Employee;
import com.freetuition.model.Request;


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

		//Get all inputs values

    	int id = Integer.parseInt(request.getParameter("idA"));
       	int emplId = Integer.parseInt(request.getParameter("emplA"));
       	String school = request.getParameter("schoolA");
       	String course = request.getParameter("courseA");
       	double price = Double.parseDouble(request.getParameter("priceA"));
       	String status = "approved";
       	String receipt = null;

       	
	
       	//WORKING CODE UNCOMMENT LATER
       	int manId = (Integer) request.getSession(false).getAttribute("userId");

       	String comments = request.getParameter("comments");
       	Employee someone = new Employee();
       	Employee employee = new Employee(emplId,"x","x","X","x",someone,"x",1,"x");
       	Employee manager = new Employee(manId,"x","x","X","x",someone,"x",1,"x");
       	
       	
       	Request req = new Request(id,employee,school,course,price,status,receipt,manager,comments);

      	
       RequestDAOImpl dao = new RequestDAOImpl();
       dao.approveRequest(req);
      
       response.sendRedirect("pages/requests-pending.html");
	}

}
