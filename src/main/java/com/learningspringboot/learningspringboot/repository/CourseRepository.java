package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
