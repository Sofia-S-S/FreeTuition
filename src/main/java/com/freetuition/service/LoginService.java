package com.freetuition.service;

import com.freetuition.exception.BusinessException;
import com.freetuition.model.Login;

public interface LoginService {

	Login letEmployeeLogin(String login, String password) throws BusinessException;
}
