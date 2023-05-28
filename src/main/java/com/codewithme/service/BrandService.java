package com.codewithme.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithme.dao.BrandDao;
import com.codewithme.model.Brand;

public class BrandService {

	public List<Brand> getAllBrands() throws ClassNotFoundException, SQLException{
		return BrandDao.getAllBrands();
		//return null;
	}
}
