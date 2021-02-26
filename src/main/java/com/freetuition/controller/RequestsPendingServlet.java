package com.freetuition.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.freetuition.dao.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Request;


/**
 * Servlet implementation class RequestsPendingServlet
 */
@WebServlet("/RequestsPendingServlet")
public class RequestsPendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RequestsPendingServlet() {
        super();
    }
    
    RequestDAOImpl repo = new RequestDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		
//		ArrayList<Request> reqList = new ArrayList<> (Arrays.asList(new Request(1,100,"Northwestern","Web-Dev 101","full-time", 600.00, "pending", new Date(),null,new Date()),
//																	new Request(2,200,"Northwestern","Web-Dev 102","full-time", 467.00, "pending", new Date(),null,new Date()),
//																	new Request(3,300,"Revature","Java","full-time", 599.00, "pending", new Date(),null,new Date())
//																	));
		
		List<Request> reqList;
		try {
			reqList = repo.findAll("pending");

		
		ObjectMapper objectMapper = new ObjectMapper();
		
		final String JSON = objectMapper.writeValueAsString(reqList);
		
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
