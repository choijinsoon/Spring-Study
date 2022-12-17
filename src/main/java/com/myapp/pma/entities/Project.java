package com.myapp.pma.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Project {
	
	@OneToMany(mappedBy = "project") //project table 매핑
	private List<Employee> employees;
	
	@Id //기본키 설정
	@GeneratedValue(strategy = GenerationType.AUTO) //id 자동 생성
	private Long projectId; //DB project_id
	
	private String name;
	private String stage;
	private String description;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(String name, String stage, String description) {
		//id는 자동생성으로 제외
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", stage=" + stage + ", description="
				+ description + "]";
	}
	
	
}
