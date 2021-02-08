package com.productcart.service;

import java.util.List;

import com.productcart.productdao.Product;

public interface ProductService {
	public List<Product> showAllProducts();
	public void addProduct(Product product);
	public void deleteProduct(int id);
}
