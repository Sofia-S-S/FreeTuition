package com.freetuition.service.impl;

import com.freetuition.dao.impl.LoginDAOImpl;
import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;
import com.freetuition.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	private LoginDAOImpl dao = new LoginDAOImpl();

	@Override
	public Login letEmployeeLogin(String login, String password) throws BusinessException {
		Login l = null;
		if(login!=null && login.matches("[a-zA-Z0-9]{2,12}")&& password!=null && password.matches("[a-zA-Z0-9]{4,12}")) {

				l = dao.letEmployeeLogin(login, password);
	
		} else {
				throw new BusinessException("Entered loging or password is INVALID. Please try again");
			}
		return l;
	}

}
