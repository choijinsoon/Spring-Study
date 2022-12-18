package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	List<Employee> findAll();
}