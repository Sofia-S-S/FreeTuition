package com.freetuition.dao;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;

public interface LoginDAO {
	
	Login letEmployeeLogin(String login, String password) throws BusinessException, ClassNotFoundException;

}
