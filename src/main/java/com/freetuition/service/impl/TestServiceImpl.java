package com.freetuition.service.impl;

import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.dao.impl.LoginDAOImpl;
import com.freetuition.dao.impl.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
import com.freetuition.model.Request;
import com.freetuition.service.TestService;

public class TestServiceImpl implements TestService{
	
	LoginDAOImpl daoL;
	EmployeeDAOImpl daoE;
	RequestDAOImpl daoR;

	@Override
	public boolean letEmployeeLogin(String login, String password) throws BusinessException {
		boolean b = false;
		if(login!=null && login.matches("[a-zA-Z0-9]{2,12}")&& password!=null && password.matches("[a-zA-Z0-9]{4,12}")) {

			daoL.letEmployeeLogin(login, password);
			b = true;

	} else {
			throw new BusinessException("Entered loging or password is INVALID. Please try again");
		}
		return b;
	}

	@Override
	public boolean createEmployee(Employee employee, Login login) throws BusinessException {
		boolean b = false;
		if(login!=null && employee!=null) {

			 daoE.createEmployee(employee, login);
			 b = true;

	} else {
			throw new BusinessException("Wrong input");
		}
		return b;
	}

	@Override
	public boolean updateEmployee(Employee employee) throws BusinessException {
		boolean b = false;
		if(employee!=null) {

			 daoE.updateEmployee(employee);
			 b = true;

	} else {
			throw new BusinessException("Wrong input");
		}
		return b;
	}

	@Override
	public boolean getEmployeeById(int id) throws BusinessException {
		boolean b = false;
		if(id > 0) {

			daoE.getEmployeeById(id);
			 b = true;

	} else {
			throw new BusinessException("Wrong input");
		}

		return b;
	}

	@Override
	public boolean getEmployeeByName(String firstName, String lastName) throws BusinessException {
		boolean b = false;
		if(firstName!=null && firstName.matches("[a-zA-Z]{2,12}")&& lastName!=null && lastName.matches("[a-zA-Z]{2,12}")) {

			daoE.getEmployeeByName(firstName, lastName);
			 b = true;

	} else {
			throw new BusinessException("Wrong input");
		}
		return b;
	}

	@Override
	public boolean getAllEmployees() throws BusinessException {

		return true;
	}

	@Override
	public boolean getAllReqsForManager(int manId, String status) throws BusinessException {
		boolean b = false;
		if(manId>0 && status.matches("[a-zA-Z]{5,12}")) {

			 daoR.getAllReqsForManager(manId, status);
			 b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean getAllReqByEmployee(int employee) throws BusinessException {
		boolean b = false;
		if(employee>0) {

			 daoR.getAllReqByEmployee(employee);
			 b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean getAllReqByEmployee(int employeeId, int managerId) throws BusinessException {
		boolean b = false;
		if(employeeId>0 && managerId>0) {

			 daoR.getAllReqByEmployee(employeeId, managerId);
			 b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean insert(Request r) throws BusinessException {
		boolean b = false;
		if(r!=null) {

			 daoR.insert(r);
			 b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean approveRequest(Request req) throws BusinessException {
		boolean b = false;
		if(req!=null) {

			daoR.approveRequest(req);
			 b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean getRequestById(int id) throws BusinessException {
		boolean b = false;
		if(id>0) {

			daoR.getRequestById(id);
			b = true;
	
		} else {
				throw new BusinessException("Wrong inputs");
			}
		return b;
	}

	@Override
	public boolean getAllRequests() throws BusinessException {

		return true;
	}

}
