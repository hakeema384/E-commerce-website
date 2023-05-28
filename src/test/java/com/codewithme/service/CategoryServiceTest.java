package com.codewithme.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.codewithme.model.Category;

class CategoryServiceTest {

	@Test
	void test() throws ClassNotFoundException, SQLException {
		CategoryService service = new CategoryService();
		Category category = new Category(1,"Mobilephones");
		List<Category> actual = new ArrayList<Category>();
		List<Category> expected = new ArrayList<Category>();
		 actual.add(category);
		actual = service.getCategories();
		expected = Arrays.asList(new Category(1,"Mobilephones"));
		//assertTrue(actual.equals(expected));
		assertArrayEquals(expected.toArray(),actual.toArray());
	}

}
