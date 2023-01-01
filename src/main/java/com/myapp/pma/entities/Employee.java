package com.myapp.pma.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.validation.constraints.Size;

@Entity
public class Employee {
	
	//N:N 관계
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
				fetch = FetchType.LAZY)
	@JoinTable(name = "project_employee", joinColumns = @JoinColumn(name = "employee_id"),
				inverseJoinColumns = @JoinColumn(name = "project_id"))
	@JsonIgnore
	private List<Project> projects;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@NotBlank(message="이름을 입력해주세요")
	@Size(min=1, max=20, message="이름은 1에서 20자 사이입니다.")
	private String firstName;

	@NotBlank(message = "성을 입력해주세요")
	@Size(min=1, max=2, message = "성은 1에서 2자 사이입니다.")
	private String lastName;

	@NotBlank(message = "이메일을 입력해주세요")
	private String email;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + "]";
	}
	
	
}
