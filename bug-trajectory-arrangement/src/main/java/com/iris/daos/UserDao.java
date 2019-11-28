package com.iris.daos;

import java.util.List;

import com.iris.models.User;

public interface UserDao {

	public User validateUser(String email,String password); 
	public List<User> getAllDeveloper();
	public List<User> getAllTester();
	public User getUserById(int userId);
	
}
