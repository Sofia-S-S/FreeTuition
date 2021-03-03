package com.freetuition.dao;

import java.util.List;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

public interface EmployeeDAO {
	
	void createEmployee(Employee employee, Login login) throws BusinessException;
	void updateEmployee(Employee employee) throws BusinessException;
	Employee getEmployeeById(int id) throws BusinessException;
	Employee getEmployeeByName(String firstName, String lastName) throws BusinessException;
	List<Employee> getAllEmployees() throws BusinessException;

}
