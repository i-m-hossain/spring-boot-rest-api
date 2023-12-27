package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentNameIgnoreCase(String departmentName);
    @Query("select d from Department d where d.departmentName iLIKE %?1%" )
    public Department findDepartmentNameByQuery(String departmentName);
}
