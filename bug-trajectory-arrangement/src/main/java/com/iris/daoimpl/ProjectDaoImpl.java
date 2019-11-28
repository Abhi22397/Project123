package com.iris.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iris.daos.ProjectDao;
import com.iris.models.Project;

import oracle.net.aso.p;

@Repository("projectDao")

public class ProjectDaoImpl implements ProjectDao{
	@Autowired
     SessionFactory sessionFactory;
	
	@Override
	public List<Project> getAllProjects() {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Query q=session.createQuery("from com.iris.models.Project");
		    List<Project> pList=q.list();
		    return pList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Project getProjectById(String projectId) {
		try{
			Session session=sessionFactory.getCurrentSession();
		    Project pObj=session.get(Project.class, projectId);
		    return pObj;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean updateProject(Project pObj) {
		try{
			Session session=sessionFactory.getCurrentSession();
		    session.update(pObj);
		    return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
