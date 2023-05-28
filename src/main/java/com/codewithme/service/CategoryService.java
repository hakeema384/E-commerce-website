package com.codewithme.service;

import java.sql.SQLException;
import java.util.List;

import com.codewithme.dao.CategoryDao;
import com.codewithme.model.Category;

public class CategoryService {
	
	public List<Category> getCategories() throws ClassNotFoundException, SQLException{
		return CategoryDao.getCategories();
	}

}
