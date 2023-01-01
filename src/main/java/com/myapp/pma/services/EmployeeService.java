package com.myapp.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.pma.dao.EmployeeProject;
import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	public List<EmployeeProject> employeeProjects() {
		return employeeRepository.employeeProjects();
	}

	public Employee findByEmployessId(long id) {
		return employeeRepository.findByEmployeeId(id);
	}

	public void update(Employee employee) {
		Employee emp = employeeRepository.findByEmployeeId(employee.getEmployeeId());

		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		employeeRepository.save(emp);
	}

	public void deleteEmployeeById(long id) {
		employeeRepository.deleteById(id);
	} 

}
