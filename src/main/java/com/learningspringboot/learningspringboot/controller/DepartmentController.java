package com.learningspringboot.learningspringboot.controller;

import com.learningspringboot.learningspringboot.entity.Department;
import com.learningspringboot.learningspringboot.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;
    DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/department")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
    @PostMapping(path="/department")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @GetMapping(path="/department/{id}")
    public Optional<Department> fetchDepartmentById(@PathVariable("id") Long departmentId){
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
