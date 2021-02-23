package com.freetuition.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.model.Employee;



/**
 * Servlet implementation class EmployeeLoginServlet
 */
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		



        String fn = request.getParameter("firstName");
		
		System.out.println("From Updateinfoservlet" +fn);

	   
//		//If I take JSON from my-info That works good
//		ObjectMapper objectMapper = new ObjectMapper();
//	    URL url = new URL("http://localhost:8080/FreeTuition/GetMyInfoServlet");
//	    Employee emp = objectMapper.readValue(url, Employee.class);
//	    System.out.println(emp);
//	    System.out.println(emp.getFirstName());
	
		





	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	

    	
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String cm = request.getParameter("company");
		
		System.out.println("From Updateinfoservlet - full name: " +fn+" "+ln+ " works for "+cm);


		System.out.println("This is POST in update-info that is UpdateInfoServlet");	
  	 System.out.println("do post" + response.toString());
    	String s = response.toString();
    	ObjectMapper objectMapper = new ObjectMapper();
		Employee emp = objectMapper.readValue(s, Employee.class);
		System.out.println(emp.getFirstName());
    	


		//Plane html
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("Update info Servlet sayd First Name is:" +request.getParameter("firstName") +" ");
//		out.println("</body></html>");

}}
