package com.myapp.pma.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Project {
	
	//N:N 관계
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH}, 
				fetch = FetchType.LAZY) //project table 매핑
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "project_id"), 
				inverseJoinColumns = @JoinColumn(name = "employee_id"))
	private List<Employee> employees;
	
	@Id //기본키 설정
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id 자동 생성
	private Long projectId; //DB project_id
	
	@NotBlank(message="프로젝트 이름을 입력해주세요")
	private String name;
	private String stage;

	@NotBlank(message="설명을 입력해주세요")
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

	public void addEmployee(Employee emp) {
		if(employees == null)
			employees = new ArrayList<>();
		
		employees.add(emp);
	}
	
	
}
