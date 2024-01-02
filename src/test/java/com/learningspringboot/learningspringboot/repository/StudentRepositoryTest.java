package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Guardian;
import com.learningspringboot.learningspringboot.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
//@DataJpaTest
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp(){

    }
    @Test
    public void saveStudent(){
        Student student=Student.builder()
                .emailId("imran.kuet14@gmail.com")
                .firstName("Md Imran")
                .lastName("Hossain")
//                .guardianEmail("guardian@gmail.com")
//                .guardianMobile("01788407805")
//                .guardianName("Guardian")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian
                .builder()
                .name("Nowsher Ali")
                .email("ali@gmail.com")
                .mobile("017123456789")
                .build();
        Student student = Student.builder()
                .emailId("imran@gmail.com")
                .firstName("Im")
                .lastName("Hossain")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }    @Test
    public void studentsList(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("student list= "+studentList);
    }

}