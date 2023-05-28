package com.codewithme.service;

import java.sql.SQLException;

import com.codewithme.dao.LoginDao;
import com.codewithme.dao.RegistrationDao;
import com.codewithme.model.Login;
import com.codewithme.model.Registration;



public class RegisterService {
	
	public boolean addUser(Registration reg) throws ClassNotFoundException, SQLException {
		return RegistrationDao.addUser(reg);
	}
	
	public int getBranchID(Login login) throws ClassNotFoundException, SQLException {
		return LoginDao.getBranchID(login);
	}
	
	public int getID(Login login) throws ClassNotFoundException, SQLException {
		return LoginDao.getID(login);
	}

	public String validateUser(Login login) throws ClassNotFoundException, SQLException {
		return LoginDao.validateUser(login);
	}
}
