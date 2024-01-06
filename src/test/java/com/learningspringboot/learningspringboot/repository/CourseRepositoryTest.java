package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Course;
import com.learningspringboot.learningspringboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;
    @Test
    public void printCourses(){
        List<Course> courses = repository.findAll();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .lastName("hossain")
                .firstName("imran")
                .build();
        Course course = Course.builder()
                .title("Hello java")
                .credit(6)
                .teacher(teacher)
                .build();
        repository.save(course);
    }
}