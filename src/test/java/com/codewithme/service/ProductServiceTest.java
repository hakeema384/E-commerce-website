package com.codewithme.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.codewithme.model.Product;

class ProductServiceTest {

	@Disabled
	void test() throws ClassNotFoundException, SQLException {
		ProductService service = new ProductService();
		Product product = new Product();
		boolean expected = true;
		boolean actual = service.addProduct(product);
		assertEquals(expected,actual,"The product got added");
	}

	@Test
	void testsendRequest() throws ClassNotFoundException, SQLException {
		ProductService service = new ProductService();
		Product product = new Product();
		boolean expected = true;
		boolean actual = service.sendRequest(product);
		assertEquals(expected,actual,"The request was sent");
	}
}
