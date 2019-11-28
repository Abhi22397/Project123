package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.UserDao;
import com.iris.models.Project;
import com.iris.models.User;
@Repository("userDao")

public class UserDaoImpl implements UserDao {
@Autowired
 SessionFactory sessionFactory;

@Override
public User validateUser(String email, String password) {
	try {
		Session session=sessionFactory.getCurrentSession();
        
        
        Query query=session.createQuery("from com.iris.models.User where email=:email and password=:password");
        query.setParameter("email", email);
        query.setParameter("password", password);
        List<User> userList=query.list();
        if (userList!=null ) {
                     return userList.get(0);
              }
        
        else {
              System.out.println("Invalid id or password");
              session.close();
        }

 } catch (Exception e) {
        e.printStackTrace();
 }
 return null;
}

@Override
public List<User> getAllDeveloper() {
	try{
		Session session=sessionFactory.getCurrentSession();
	    Query q=session.createQuery("from com.iris.models.User where desg='Developer'");
	    List<User> uList=q.list();
	    return uList;
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@Override
public List<User> getAllTester() {
	try{
		Session session=sessionFactory.getCurrentSession();
	    Query q=session.createQuery("from com.iris.models.User where desg='Tester'");
	    List<User> uList=q.list();
	    return uList;
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

@Override
public User getUserById(int userId) {
	try {
		Session session=sessionFactory.getCurrentSession();
		User userObj=session.get(User.class,userId);
		return userObj;
	}catch (Exception e) {
		e.printStackTrace();
	}

	return null;
}



}
