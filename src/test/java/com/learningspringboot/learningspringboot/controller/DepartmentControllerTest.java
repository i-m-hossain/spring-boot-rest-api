package com.learningspringboot.learningspringboot.controller;

import com.learningspringboot.learningspringboot.entity.Department;
import com.learningspringboot.learningspringboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;
    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentId(1L)
                .departmentName("CSE")
                .departmentCode("122")
                .departmentAddress("Khulna")
                .build();
    }

    @Test
    void fetchDepartmentList() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(Optional.ofNullable(this.department));
        mockMvc.perform(get("/department/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value(department.getDepartmentName()))
;    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment=Department.builder()
                .departmentId(1L)
                .departmentName("CSE")
                .departmentCode("122")
                .departmentAddress("Khulna")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(this.department);
        mockMvc.perform(
                post("/department")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\n" +
                        "    \"departmentName\":\"CSE\",\n" +
                        "    \"departmentCode\": \"122\",\n" +
                        "    \"departmentAddress\": \"Khulna\"\n" +
                        "}")
                )
                .andExpect(status().isOk());
    }
}