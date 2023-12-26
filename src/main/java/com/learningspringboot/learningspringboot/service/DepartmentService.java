package com.learningspringboot.learningspringboot.service;

import com.learningspringboot.learningspringboot.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Optional<Department> fetchDepartmentById(Long id);

   public void deleteDepartmentById(Long departmentId);

   public Department updateDepartmentById(Long departmentId, Department department);

   public Department fetchDepartmentByName(String departmentName);
}
