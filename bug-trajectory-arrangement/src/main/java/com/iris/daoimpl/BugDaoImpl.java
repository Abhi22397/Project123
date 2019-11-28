package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.BugDao;
import com.iris.models.BugType;
import com.iris.models.User;

@Repository("bugDao")
public class BugDaoImpl implements BugDao{
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public List<BugType> getAllBug() {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Query q=session.createQuery("from com.iris.models.BugType");
		    List<BugType> bugList=q.list();
		    return bugList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public BugType getBugById(int bId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			BugType bugTypeList=session.get(BugType.class, bId);
			return bugTypeList;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
