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
    }
    @Test
    public void studentsList(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("student list= "+studentList);
    }

    @Test
    public void findStudentByName(){
        /*--using jpa----*/
        List<Student> studentList = studentRepository.findStudentByFirstName("im");
        System.out.println("student list= " + studentList);
    }
    @Test
    public void findStudentByFirstNameContaining(){
        List <Student> studentList = studentRepository.findByFirstNameContaining("imr");
        System.out.println("Student list by firstname"+studentList);
    }
    //JPQL
    @Test
    public void findStudentByEmailId(){
        Student student  =
                studentRepository
                        .getStudentByEmailAddress("imran.kuet14@gmail.com");
        System.out.println("student by email"+ student);
    }
    /*--using native query----*/
    @Test
    public  void getStudentByEmail(){
        List<Student> studentList = studentRepository.getStudentByEmail("imran.kuet14@gmail.com");
        System.out.println("student list= " + studentList);
    }
    /*--- using query with named param--*/
    @Test
    public void getStudentByEmailWithNameParam(){
        List<Student> studentList = studentRepository.getStudentByEmailWithNameParam("imran.kuet14@gmail.com");
        System.out.println("student list: "+studentList);
    }
    @Test
    public void updateStudentNameByEmailId(){
        int result = studentRepository.updateStudentNameByEmailId("Mr. Imran", "imran.kuet14@gmail.com");
        System.out.println(result);
    }

}