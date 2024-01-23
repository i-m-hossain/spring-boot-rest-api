package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Course;
import com.learningspringboot.learningspringboot.entity.Student;
import com.learningspringboot.learningspringboot.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords= PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
        List<Course> courses = repository.findAll(secondPageWithTwoRecords).getContent();
        long totalElements = repository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = repository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("courses = " + courses);
        System.out.println("totalElements = " + totalElements);
        System.out.println("totalPages = " + totalPages);

    }
    @Test
    public void findAllWithSorting(){
        Pageable sortByTitle = PageRequest.of(0,3, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,3, Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest
                .of(0, 3, Sort.by("title")
                        .descending()
                        .and(
                                Sort.by("credit")
                        )
                );
    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0, 10);
        List<Course> courses = repository.findByTitleContaining("D", firstPageTenRecords).getContent();

    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Md")
                .lastName("hossain")
                .build();
        Student student1 = Student.builder()
                .firstName("peter")
                .lastName("parker")
                .emailId("peter@parker2.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(4)
                .teacher(teacher)
                .build();
        course.addStudents(student1);
        Course save = repository.save(course);
    }
}