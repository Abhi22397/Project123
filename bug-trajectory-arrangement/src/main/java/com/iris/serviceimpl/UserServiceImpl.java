package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.service.UserService;


@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
   private UserDao userDao;
	@Override
	public User validateUser(int id, String password) {
		try {
			 return userDao.validateUser(id, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<User> getAllUserByDesg(String desg) {
		try {
			 return userDao.getAllUserByDesg(desg);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
