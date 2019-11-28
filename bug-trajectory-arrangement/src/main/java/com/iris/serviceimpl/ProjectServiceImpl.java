package com.iris.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.ProjectDao;
import com.iris.models.Project;
import com.iris.service.ProjectService;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
  @Autowired 
  ProjectDao projectDao;  
	@Override
	public List<Project> getAllProjects() {
			return projectDao.getAllProjects();
	}
	
	@Override
	public Project getProjectById(String projectId) {
		return projectDao.getProjectById(projectId);
	}

	@Override
	public boolean updateProject(Project pObj) {
		return projectDao.updateProject(pObj);
	}

}
