package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp.pma.dao.EmployeeProject;
import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository projectService;

	@Autowired
	EmployeeRepository employeeService;

	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projectList = projectService.findAll();
		List<EmployeeProject> empProList = employeeService.employeeProjects();
		System.out.println(projectList);
		System.out.println("hehe");
		System.out.println(empProList);
		model.addAttribute("projectList", projectList);
		model.addAttribute("empProList", empProList);
		
		return "main/home";
	}

	@GetMapping("/list")
	public String displayemployee(Employee employee) {
		return "employees/employeeList";
	}
}
