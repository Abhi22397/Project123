package com.iris.daos;

import java.util.List;

import com.iris.models.Project;

public interface ProjectDao {

	public List<Project> getAllProjects();
	public Project getProjectById(String projectId);
	public boolean updateProject(Project pObj);
	
}
