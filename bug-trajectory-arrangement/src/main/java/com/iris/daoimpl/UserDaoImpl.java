package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.UserDao;
import com.iris.models.User;
@Repository("userDao")

public class UserDaoImpl implements UserDao {
@Autowired
 SessionFactory sessionFactory;

@Override
public User validateUser(int id, String password) {
	try {
		Session session=sessionFactory.getCurrentSession();
		User userObj=session.get(User.class,id);

		if(userObj!=null)
		{
			if(userObj.getPassword().equals(password))
			{
				System.out.println(userObj);
				return userObj;
			}
		}
	}catch (Exception e) {
		e.printStackTrace();
	}

	return null;
}

@Override
public List<User> getAllUserByDesg(String desg) {
	try{
		Session session=sessionFactory.getCurrentSession();
	    Query q=session.createQuery("from com.iris.models.User where Designation in('Tester','Developer')");
	    List<User> uList=q.list();
	    return uList;
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}


}
