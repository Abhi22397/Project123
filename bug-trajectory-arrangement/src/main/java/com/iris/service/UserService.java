package com.iris.service;

import java.util.List;


import com.iris.models.User;

public interface UserService {
	public User validateUser(int id,String password); 
	public List<User> getAllUserByDesg(String desg);


}
