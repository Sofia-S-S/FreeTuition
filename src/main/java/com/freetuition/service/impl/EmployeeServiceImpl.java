package com.freetuition.service.impl;

import java.util.List;

import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
import com.freetuition.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAOImpl dao = new EmployeeDAOImpl();

	@Override
	public void createEmployee(Employee employee, Login login) throws BusinessException {

		if(login!=null && employee!=null) {

				 dao.createEmployee(employee, login);
	
		} else {
				throw new BusinessException("Wrong input");
			}
		
	}

	@Override
	public void updateEmployee(Employee employee) throws BusinessException {
		if(employee!=null) {

			 dao.updateEmployee(employee);

	} else {
			throw new BusinessException("Wrong input");
		}
	
}

	@Override
	public Employee getEmployeeById(int id) throws BusinessException {
		Employee emp = null;
		if(id > 0) {

				emp = dao.getEmployeeById(id);
	
		} else {
				throw new BusinessException("Wrong input");
			}
		return emp;
	}


	@Override
	public Employee getEmployeeByName(String firstName, String lastName) throws BusinessException {
		Employee emp = null;
		if(firstName!=null && firstName.matches("[a-zA-Z]{2,12}")&& lastName!=null && lastName.matches("[a-zA-Z]{2,12}")) {

				emp = dao.getEmployeeByName(firstName, lastName);
	
		} else {
				throw new BusinessException("Wrong input");
			}
		return emp;
	}

	@Override
	public List<Employee> getAllEmployees() throws BusinessException {
		List<Employee> list = null;
	

				list = dao.getAllEmployees();

		return list;
	}

}
