package com.iris.service;

import java.util.List;


import com.iris.models.User;

public interface UserService {
	public User validateUser(String email,String password); 
	public List<User> getAllDeveloper();
	public List<User> getAllTester();
	public User getUserById(int userId);

}
