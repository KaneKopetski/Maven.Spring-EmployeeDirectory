package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.entity.Department;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/department/ping")
    public String ping(){
        System.out.println("received ping :");
        return "hi There";
    }
    @PostMapping("/department/")
    public Department createDepartment(@RequestBody Department dept){
        System.out.println("received Post :");
        return repository.save(dept);
    }
    @PutMapping("/department/{emp_number}")
    public Department updateDepartment(@PathVariable long dept_number, @RequestBody Department department){
        System.out.println("received Post :");
        department.setNumber(dept_number);
        return repository.save(department);
    }
    @GetMapping("/department/{emp_number}")
    public Optional<Department> getDepartment(@PathVariable long dept_number){
        return repository.findById(dept_number);
    }

    @GetMapping("/department/")
    public Iterable<Department> getAllDepartment(){
        return repository.findAll();
    }
}
