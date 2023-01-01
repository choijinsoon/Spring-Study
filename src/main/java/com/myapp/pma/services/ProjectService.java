package com.myapp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Project;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> findAll() {
		return projectRepository.findAll();
	}
	
	public void save(Project project) {
		projectRepository.save(project);
	}

	public void update(Project project) {
		Project prj = projectRepository.findByProjectId(project.getProjectId());

		prj.setName(project.getName());
		prj.setDescription(project.getDescription());

		projectRepository.save(prj);
	}

	public void deleteProjectById(long id) {
		projectRepository.deleteById(id);
	} 
}
