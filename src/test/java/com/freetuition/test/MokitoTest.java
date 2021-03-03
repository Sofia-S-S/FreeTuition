package com.freetuition.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.freetuition.dao.impl.EmployeeDAOImpl;
import com.freetuition.dao.impl.LoginDAOImpl;
import com.freetuition.dao.impl.RequestDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Employee;
import com.freetuition.model.Login;
import com.freetuition.service.impl.TestServiceImpl;

public class MokitoTest {
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
	}   
	
    @InjectMocks
    TestServiceImpl service;
    
    @Mock
    LoginDAOImpl logMock;
    
    @Mock
    EmployeeDAOImpl empMock;
    
    @Mock
    RequestDAOImpl reqMock;
    

    Employee employee = new Employee(1,"Sasa","Dogle","West","Manager",5,"sasa@west.com",698766666,"5867 G Ffhhh Sl");
    Login login = new Login(1,"fgggf","fghhhd");
    
    @Test
    public void letEmployeeLogin() throws BusinessException {
    	
    	boolean b = service.letEmployeeLogin("ffff", "yyrtg");
    	assertEquals(true, b);
    	verify(logMock, times(1)).letEmployeeLogin("ffff", "yyrtg"); 	   	
    }

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throwsNullPointerException() {
            thrown.expect(NullPointerException.class);
            throw new NullPointerException();
    }
    @Test
    public void createEmployee() throws BusinessException {
    	
    	boolean b = service.createEmployee(employee, login);
    	assertEquals(true, b);
    	verify(empMock, times(1)).createEmployee(employee, login);   	
    	
    }
    @Test
    public void getEmployeeById() throws BusinessException {
    	
    	boolean b = service.getEmployeeById(15);
    	assertEquals(true, b);
    	verify(empMock, times(1)).getEmployeeById(15);
    }
    
    @Test
    public void getEmployeeByName() throws BusinessException  {
    	
    	boolean b = service.getEmployeeByName("Fggjj","Fggjj");
    	assertEquals(true, b);
    	verify(empMock, times(1)).getEmployeeByName("Fggjj","Fggjj");
    }
    
    

}
