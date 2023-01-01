package com.myapp.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.myapp.pma.dao.EmployeeRepository;
import com.myapp.pma.entities.Employee;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/app-api/employees")
public class EmployeeApiController {

    @Autowired
    private EmployeeRepository empRepo;

    @GetMapping
    public Iterable<Employee> getEmployees(){
        return empRepo.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return empRepo.findByEmployeeId(id);
    }
    
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee){
        return empRepo.save(employee);
    }

    @PutMapping(path="/{id}", consumes="application/json")
    public Employee update(@PathVariable long id, @RequestBody Employee employee){
        Employee emp = empRepo.findByEmployeeId(id);

        if(employee.getEmail() != null)
            emp.setEmail(employee.getEmail());
        if(employee.getFirstName() != null)
            emp.setFirstName(employee.getFirstName());
        if(employee.getLastName() != null)
            emp.setLastName(employee.getLastName());

        return empRepo.save(emp);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        try{
            empRepo.deleteById(id);
        } catch (Exception e){
            System.out.println("삭제 안됨");
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Employee> findPaginatedEmployess(@RequestParam(value="page", defaultValue = "1") int page,
                                                    @RequestParam(value="size", defaultValue = "5") int size){
        Pageable pageable = PageRequest.of(page, size);
        return empRepo.findAll(pagaalbe);
        }

}
