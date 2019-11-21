package com.iris.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iris.daos.ProjectDao;
import com.iris.models.Project;
import com.iris.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
  @Autowired 
  ProjectDao projectDao;  
	@Override
	public List<Project> getAllProjects() {
		try {
			return projectDao.getAllProjects();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
