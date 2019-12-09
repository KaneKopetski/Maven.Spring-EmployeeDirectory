package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.entity.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/employee/")
    public Employee createEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }
    @PutMapping("/employee/{emp_number}")
    public Employee updateEmployee(@PathVariable long emp_number, @RequestBody Employee employee){
        employee.setEmployee_number(emp_number);
        return repository.save(employee);
    }
    @GetMapping("/employee/{emp_number}")
    public Optional<Employee> getEmployee(@PathVariable long emp_number){
        return repository.findById(emp_number);
    }

    @GetMapping("/employee/")
    public Iterable<Employee> getEmployee(){
        return repository.findAll();
    }
}
