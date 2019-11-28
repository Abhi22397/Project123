package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.service.UserService;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
   private UserDao userDao;
	@Override
	public User validateUser(String email, String password) {
		try {
			System.out.println(userDao.validateUser(email, password));
			 return userDao.validateUser(email, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<User> getAllDeveloper() {
		try {
			 return userDao.getAllDeveloper();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<User> getAllTester() {
		try {
			 return userDao.getAllTester();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

}
