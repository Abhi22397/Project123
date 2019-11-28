package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.SeverityDao;
import com.iris.models.Severity;
 @Repository("severityDao")
public class SeverityDaoImpl implements SeverityDao {
	@Autowired
    SessionFactory sessionFactory;
	@Override
	public List<Severity> getAllSeverity() {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Query q=session.createQuery("from com.iris.models.Severity");
		    List<Severity> sList=q.list();
		    return sList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
