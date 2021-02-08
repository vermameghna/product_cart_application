package com.productcart.service;

import com.productcart.userdao.User;
import com.productcart.userdao.UserDao;
import com.productcart.userdao.UserDaoImpl;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	@Override
	public void addUser(User user) {
		 userDao.addUser(user);
	}

	@Override
	public User getUser(String username, String password) {
		return userDao.getUser(username,password);
	}
	
}
