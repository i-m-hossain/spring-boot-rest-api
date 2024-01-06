package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
