package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.BugAllocationDetailDao;
import com.iris.models.BugAllocationDetails;


@Repository("bugAllocationDetailDao")
public class BugAllocationDetailsDaoImpl implements BugAllocationDetailDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public boolean saveBugDetails(BugAllocationDetails bugAllocate) {
		try{
			Session session=sessionFactory.getCurrentSession();
		   session.save(bugAllocate);
		   return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<BugAllocationDetails> getAllBugDesc() {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Query q=session.createQuery("from com.iris.models.BugAllocationDetails");
		    List<BugAllocationDetails> bugList=q.list();
		    return bugList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean update(BugAllocationDetails bugAllocate) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(bugAllocate);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public BugAllocationDetails getBugAllocationById(int bugAllocateId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			BugAllocationDetails bugALlocation=session.get(BugAllocationDetails.class,bugAllocateId);
			return bugALlocation;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BugAllocationDetails> getBugDesc(int id) {
		try{
		Session session=sessionFactory.getCurrentSession();
	    Query q=session.createQuery("from com.iris.models.BugAllocationDetails where userId=:id");
	    q.setParameter("id",id);
	    List<BugAllocationDetails> bugList=q.list();
	    return bugList;
	    }catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}


}
