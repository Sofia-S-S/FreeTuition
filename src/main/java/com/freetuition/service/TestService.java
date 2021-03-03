package com.freetuition.service;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
import com.freetuition.model.Request;

public interface TestService {
	
	boolean letEmployeeLogin(String login, String password) throws BusinessException;
	
	boolean createEmployee(Employee employee, Login login) throws BusinessException;
	boolean updateEmployee(Employee employee) throws BusinessException;
	boolean getEmployeeById(int id) throws BusinessException;
	boolean getEmployeeByName(String firstName, String lastName) throws BusinessException;
	boolean getAllEmployees() throws BusinessException;
	
	boolean getAllReqsForManager(int manId , String status) throws BusinessException;
	boolean getAllReqByEmployee(int employee) throws BusinessException;
	boolean getAllReqByEmployee(int employeeId, int managerId) throws BusinessException;
	boolean insert(Request r) throws BusinessException;
	boolean approveRequest(Request req) throws BusinessException;
	boolean getRequestById(int id) throws BusinessException;
	boolean getAllRequests() throws BusinessException;
	

}
