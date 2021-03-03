package com.freetuition.service;

import java.util.List;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;

public interface EmployeeService {

	void createEmployee(Employee employee, Login login) throws BusinessException;
	void updateEmployee(Employee employee) throws BusinessException;
	Employee getEmployeeById(int id) throws BusinessException;
	Employee getEmployeeByName(String firstName, String lastName) throws BusinessException;
	List<Employee> getAllEmployees() throws BusinessException;
}
