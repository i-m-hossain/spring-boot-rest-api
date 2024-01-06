package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Course;
import com.learningspringboot.learningspringboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository repository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course
                .builder()
                .title("DBA")
                .credit(4)
                .build();
        Course courseJava = Course
                .builder()
                .title("Java")
                .credit(4)
                .build();
        Teacher teacher = Teacher
                .builder()
//                .courses(List.of(courseJava, courseDBA))
                .firstName("Akshay")
                .lastName("Saini")
                .build();
        repository.save(teacher);
    }
}