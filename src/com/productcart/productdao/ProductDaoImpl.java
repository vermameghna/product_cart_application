package com.productcart.productdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.productcart.dao.ConnectionFactory;
import com.productcart.dao.DataAccessException;

public class ProductDaoImpl implements ProductDao{
	
	private Connection connection;
	
	public ProductDaoImpl() {
		//products = new ArrayList<>();
		connection = ConnectionFactory.getConnection();
	}
	
	@Override
	public List<Product> showAllProducts() {
		 List<Product> products =new ArrayList<>();
		try {

			PreparedStatement pstmt = connection.prepareStatement("select * from productCart");
			pstmt.execute();
			ResultSet rs = pstmt.getResultSet();
			
			while(rs.next()) {
				
				products.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getInt(3),
						rs.getInt(4)));
			}
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		return products;
		
	}

	@Override
	public void addProduct(Product product) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into productCart(name,price,quantity) values(?,?,?)");
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.setInt(3, product.getQuantity());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new DataAccessException(e.getCause().getMessage());
		}
	}

	@Override
	public void deleteProduct(int id) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("delete from productCart where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new DataAccessException(e.getCause().getMessage());
		}
	}

	@Override
	public Product getProductById(int id) {
		Product tempProduct = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("select * from productCart where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("getproduct by id-----------------------");
			
			if(rs.next()) {
				tempProduct = new Product(rs.getInt("id"),
						rs.getString("name"), 
						rs.getInt("price"), 
						rs.getInt("quantity"));
			}
			
			if(tempProduct != null) {
				return tempProduct;
			}else {
				throw new DataAccessException("Product of" + id + "not found");
			}
			
			
		} catch (SQLException e) {
			throw new DataAccessException(e.getCause().getMessage());
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("update productCart set price=?, quantity=? where id=?");
			pstmt.setInt(1, product.getPrice());
			pstmt.setInt(2, product.getQuantity());
			pstmt.setInt(3, product.getId());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DataAccessException(e.getCause().getMessage());
		}
		
		
	}

}
