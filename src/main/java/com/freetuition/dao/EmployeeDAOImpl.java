package com.freetuition.dao;

import java.util.List;

import com.freetuition.model.Employee;
import com.freetuition.model.Request;
import com.freetuition.model.RequestApproved;
import com.freetuition.model.RequestRejected;

public class EmployeeDAOImpl {

	// Create Employee // Create Login
	public boolean createEmployee() {
		return false;	
	}
	// Get Employee // Get his Manager Name
	public Employee getEmployeeById() {
		return null;	
	}
	
	//Create Request with status "open"
	public boolean createRequest() {
		return false;	
	}
	
	//Create ReimbursementApproved //Update status of Request to "approved"
	public boolean approveRequest() {
		return false;	
	}
	
	//Create ReimbursementRejected //Update status of Request to "rejected"
	public boolean rejectRequest() {
		return false;	
	}
	
	//Get All Requests join with Employee (Sort by employee or manager and status)
	public List<Request> getAllRequests() {
		return null;	
	}
	
	public Request getRequestById(int requestId) {
		return null;	
	}
	
	public RequestApproved getApprovedRequest (int  requestId) {
		return null;
		
	}
	public RequestRejected getRejectedRequest (int  requestId) {
		return null;
		
	}
	
}
