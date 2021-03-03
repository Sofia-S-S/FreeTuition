package com.freetuition.dao;

import java.util.List;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Request;

public interface RequestDAO {

	List<Request> getAllReqsForManager(int manId , String status) throws BusinessException;
	List<Request> getAllReqByEmployee(int employee) throws BusinessException;
	List<Request> getAllReqByEmployee(int employeeId, int managerId) throws BusinessException;
	void insert(Request r) throws BusinessException;
	void approveRequest(Request req) throws BusinessException;
	Request getRequestById(int id) throws BusinessException;
	List<Request> getAllRequests() throws BusinessException;
}
