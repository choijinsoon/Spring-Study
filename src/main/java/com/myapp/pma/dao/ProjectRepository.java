package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

	@Override
	List<Project> findAll();

	
	Project findByProjectId(long id);
}
