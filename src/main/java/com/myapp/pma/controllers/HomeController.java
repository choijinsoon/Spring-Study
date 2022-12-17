package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.dao.ProjectRepository;
import com.myapp.pma.entities.Employee;
import com.myapp.pma.entities.Project;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projectList = (List<Project>) projectRepository.findAll();
		model.addAttribute("projectList", projectList);
		
		List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
		model.addAttribute("employeeList", employeeList);
		return "main/home";
	}
}
