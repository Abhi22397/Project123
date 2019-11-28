package com.iris.service;

import java.util.List;
import com.iris.models.Project;

public interface ProjectService {
	public List<Project> getAllProjects();
	public Project getProjectById(String projectId);
	public boolean updateProject(Project pObj);

}
