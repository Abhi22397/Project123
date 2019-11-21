package com.iris.daos;

import java.util.List;

import com.iris.models.User;

public interface UserDao {
public User validateUser(int id,String password); 
public List<User> getAllUserByDesg(String desg);

}
