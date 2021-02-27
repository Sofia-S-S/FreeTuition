package com.freetuition.controller;

import java.io.IOException;
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
 * Servlet implementation class MyRequestsServlet
 */
@WebServlet("/MyRequestsServlet")
public class MyRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MyRequestsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    RequestDAOImpl repo = new RequestDAOImpl();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("application/json");

		
		List<Request> reqList;
		try {
			int id = (int) request.getSession(false).getAttribute("userId");
			reqList = repo.getAllReqByEmployee(id);

		
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
