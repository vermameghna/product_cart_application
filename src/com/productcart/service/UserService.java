package com.productcart.service;

import com.productcart.userdao.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username,String password);
}
