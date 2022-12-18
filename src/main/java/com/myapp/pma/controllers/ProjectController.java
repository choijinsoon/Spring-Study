package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;
import com.myapp.pma.services.EmployeeService;
import com.myapp.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private EmployeeService	employeeService;

	@GetMapping("/")
	public String displayProjectForm(Model model) {
		List<Project> projecList = projectService.findAll();
		model.addAttribute("projecList", projecList);
		return "projects/projecList";
	}
	
	@GetMapping("/new")
	public String newProjectForm(Model model) {
		Project p = new Project();
		model.addAttribute("project", p);
		
		List<Employee> empList = (List<Employee>) employeeService.findAll();
		model.addAttribute("empList", empList);
		return "projects/new-project";
	}
    
	@PostMapping("/save")
	public String createProject(Project project) {
		projectService.save(project); //project 객체를 DB의 테이블에 저장
		
		return "redirect:/projects/"; 
	}
}
