package com.myapp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{

}
