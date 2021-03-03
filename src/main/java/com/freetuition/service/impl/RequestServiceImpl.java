package com.freetuition.service.impl;

import java.util.List;

import com.freetuition.dao.impl.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Request;
import com.freetuition.service.RequestService;

public class RequestServiceImpl implements RequestService {
	
	private RequestDAOImpl dao = new RequestDAOImpl();

	@Override
	public List<Request> getAllReqsForManager(int manId, String status) throws BusinessException {
		List<Request> list = null;
		if(manId>0 && status.matches("[a-zA-Z]{5,12}")) {

			 list = dao.getAllReqsForManager(manId, status);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return  list;
	}
	

	@Override
	public List<Request> getAllReqByEmployee(int employee) throws BusinessException {
		List<Request> list = null;
		if(employee>0) {

			 list = dao.getAllReqByEmployee(employee);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return  list;
	}

	@Override
	public List<Request> getAllReqByEmployee(int employeeId, int managerId) throws BusinessException {
		List<Request> list = null;
		if(employeeId>0 && managerId>0) {

			 list = dao.getAllReqByEmployee(employeeId, managerId);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return  list;
	}

	@Override
	public void insert(Request r) throws BusinessException {
		if(r!=null) {

			 dao.insert(r);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
	}
	@Override
	public void approveRequest(Request req) throws BusinessException {
		if(req!=null) {

			dao.approveRequest(req);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		
	}

	@Override
	public Request getRequestById(int id) throws BusinessException {
		Request r = null;
		if(id>0) {

			r = dao.getRequestById(id);
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return  r;
	}

	@Override
	public List<Request> getAllRequests() throws BusinessException {
		
		List<Request> list = dao.getAllRequests();

		return  list;
	}

}
