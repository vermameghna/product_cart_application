package com.productcart.userdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.productcart.dao.ConnectionFactory;
import com.productcart.dao.DataAccessException;
import com.productcart.dao.UserNotFoundException;

public class UserDaoImpl implements UserDao{
	private Connection connection;
	
	
	public UserDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(User user) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into user(username,password) values(?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public User getUser(String username,String password) {
		User user = null;
		try {
			PreparedStatement pstmt = connection.prepareStatement("select * from user where username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				user = new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3));
			}else {
				throw new UserNotFoundException("User for " + username + " is not found :(");
			}
			
		} catch (SQLException e) {
			throw new DataAccessException(e.getMessage());
		}
		
		return user;
	}

	

}
