package com.myapp.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.pma.entities.Employee;
import com.myapp.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String displayEmployeeForm(Model model) {
		List<Employee> employeeList = employeeService.findAll();
		model.addAttribute("employeeList", employeeList);
		return "employees/employeeList";
	}
	
	@GetMapping("/new")
	public String newEmployeeEmpForm(Model model) {
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String createEmployee(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/new";
	}

	@GetMapping("/update")
	public String displayEmployeeUpdateForm(@RequestParam("id") long id, Model model) {
		Employee employee = employeeService.findByEmployessId(id);
		model.addAttribute("employee", employee);
		return "employess/new-employee";
	}
}
