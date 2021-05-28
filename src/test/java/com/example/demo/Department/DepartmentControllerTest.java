package com.example.demo.Department;

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

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private Department department;

    @BeforeEach
    void setUp() {
      /*  department = Department.builder()
                .departmentName("Software Engineer")
                .departmentCode("ht -7821")
                .departmentAddress("Msa")
                .departmentId(1L)
                .build();*/
    }

    @Test
    void saveDepartment() {
    /*  Department  inputDepartment = Department.builder()
                .departmentName("Software Engineer")
                .departmentCode("ht -7821")
                .departmentAddress("Msa")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/department")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "    \"departmentName\" : \"Comp-science55\",\n" +
                "    \"departmentAddress\" : \"IT\",\n" +
                "    \"departmentCode\" : \"002\"\n" +
                "}"))
        .andExpect(MockMvcResultMatchers.status().isOk());*/
    }

    @Test
    void getDepartmentById() {
    }
}