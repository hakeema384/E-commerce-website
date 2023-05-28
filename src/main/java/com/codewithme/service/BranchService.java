package com.codewithme.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithme.dao.BranchDao;
import com.codewithme.model.Branch;

public class BranchService {
	
	public List<Branch> viewBranches() throws ClassNotFoundException, SQLException{
		return BranchDao.viewBranches();
	}

}
