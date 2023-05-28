package com.codewithme.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithme.dao.SalesAgentDAO;
import com.codewithme.model.SalesAgent;

public class SAService {
	public List<SalesAgent> getAllSA() throws ClassNotFoundException, SQLException{
		return SalesAgentDAO.getAllSA();
	}
	
	public boolean addSA(SalesAgent sa) throws ClassNotFoundException, SQLException {
		return SalesAgentDAO.addSA(sa);
	}
	
	public boolean updateSA (SalesAgent sa) throws ClassNotFoundException, SQLException {
		return SalesAgentDAO.updateSA(sa);
	}
	
	public boolean deleteSA(int s_id ) throws ClassNotFoundException, SQLException {
		return SalesAgentDAO.deleteSA(s_id);
	}

}
