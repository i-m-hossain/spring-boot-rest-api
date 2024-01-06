package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Course;
import com.learningspringboot.learningspringboot.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title("Namaste Java")
                .credit(4)
                .build();
        CourseMaterial courseMaterial = CourseMaterial
                .builder()
                .course(course)
                .url("www.google.com")
                .build();
        repository.save(courseMaterial);
    }
    @Test
    public void printCourseMaterials(){
        List<CourseMaterial> courseMaterials =repository.findAll();
        System.out.println("course materials "+ courseMaterials);
    }

}