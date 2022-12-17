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

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project p = new Project();
		model.addAttribute("project", p);
		
		List<Employee> empList = (List<Employee>) employeeRepository.findAll();
		model.addAttribute("empList", empList);
		return "projects/new-project";
	}
    
	@PostMapping("/save")
	public String createProject(Project project,@RequestParam("employees") List<Long> ids) {
		projectRepository.save(project); //project 객체를 DB의 테이블에 저장
		
		List<Employee> selectEmployees = (List<Employee>) employeeRepository.findAllById(ids);
		for (Employee emp : selectEmployees) {
			emp.setProject(project); //직원에 프로젝트 입력
			employeeRepository.save(emp); //DB에 저장
		}
		return "redirect:/projects/new"; //post-redirect-get 패턴(/new > /save > /new)
	}
}
