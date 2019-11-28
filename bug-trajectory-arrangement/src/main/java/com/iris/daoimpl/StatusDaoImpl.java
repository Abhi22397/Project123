package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.StatusDao;
import com.iris.models.BugStatus;

@Repository("statusDao")
public class StatusDaoImpl implements StatusDao{
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public List<BugStatus> getAllStatus() {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Query q=session.createQuery("from com.iris.models.BugStatus");
		    List<BugStatus> statusList=q.list();
		    return statusList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateStatus() {
		// TODO Auto-generated method stub
		return false;
	}

}
