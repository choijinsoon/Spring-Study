package com.myapp.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
