package com.myapp.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.myapp.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	@Override
	List<Employee> findAll();

	@Query(nativeQuery = true, value = 
			"SELECT LAST_NAME AS lastName ,FIRST_NAME AS firstName , COUNT(PROJECT_ID) AS count "
			+ "FROM EMPLOYEE e "
			+ "LEFT JOIN PROJECT_EMPLOYEE pe "
			+ "ON e.EMPLOYEE_ID = pe.EMPLOYEE_ID "
			+ "GROUP BY LAST_NAME ,FIRST_NAME, e.EMPLOYEE_ID "
			+ "ORDER BY count DESC")
	public List<EmployeeProject> employeeProjects();

	Employee findByEmployeeId(long id);
}