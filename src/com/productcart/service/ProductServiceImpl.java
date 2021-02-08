package com.productcart.service;

import java.util.List;

import com.productcart.productdao.Product;
import com.productcart.productdao.ProductDao;
import com.productcart.productdao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	private ProductDao productDao;
	
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	@Override
	public List<Product> showAllProducts() {
		return productDao.showAllProducts();
	}

	@Override
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}

	@Override
	public void deleteProduct(int id) {
		productDao.deleteProduct(id);
	}

}
