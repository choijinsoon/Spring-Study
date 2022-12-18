package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;
import com.myapp.pma.services.EmployeeService;
import com.myapp.pma.services.ProjectService;

@Controller
public class HomeController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projectList = (List<Project>) projectService.findAll();
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("projectList", projectList);
		model.addAttribute("employeeList", employeeList);
		
		return "main/home";
	}
	@GetMapping("/list")
	public String displayemployee(Employee employee) {
		return "employees/employeeList";
	}	
}
