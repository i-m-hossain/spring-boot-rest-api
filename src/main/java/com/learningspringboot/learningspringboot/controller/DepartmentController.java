package com.learningspringboot.learningspringboot.controller;

import com.learningspringboot.learningspringboot.entity.Department;
import com.learningspringboot.learningspringboot.error.DepartmentNotFoundException;
import com.learningspringboot.learningspringboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/department")
    public List<Department> fetchDepartmentList(){
        logger.info("Inside fetchDepartmentList method");
        return departmentService.fetchDepartmentList();
    }
    @PostMapping(path="/department")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside saveDepartment method");
        return departmentService.saveDepartment(department);
    }
    @GetMapping(path="/department/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping(path="/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted successfully";
    }
    @PutMapping(path="/department/{id}")
    public Department updateDepartmentById(
            @PathVariable("id") Long departmentId,
            @RequestBody Department department
    ){
        return departmentService.updateDepartmentById(departmentId, department);
    }
    @GetMapping(path = "/department/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
