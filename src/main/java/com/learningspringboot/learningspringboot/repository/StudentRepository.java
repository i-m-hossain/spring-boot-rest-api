package com.learningspringboot.learningspringboot.repository;

import com.learningspringboot.learningspringboot.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    public List<Student> findStudentByFirstName(String name);
    public List<Student> findByFirstNameContaining(String name);

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    public Student getStudentByEmailAddress(String emailId);

    //Native query
    @Query(
            value = "select * from tbl_students as s where s.email_address=?1",
            nativeQuery = true
    )
    public List<Student> getStudentByEmail(String name);

    @Query(
            value = "select * from tbl_students as s where s.email_address=:emailId",
            nativeQuery = true
    )
    public List<Student> getStudentByEmailWithNameParam(@Param("emailId") String emailId);
    @Modifying
    @Transactional
    @Query(
            value="update tbl_students as s set s.first_name=?1 where s.email_address=?2",
            nativeQuery=true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
