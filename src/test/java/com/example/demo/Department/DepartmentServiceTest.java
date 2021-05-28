package com.example.demo.Department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    public DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp(){
        System.out.println(">>runs before tests<<");

        Department department = new Department(1L,"IT","Delhi","Me -0021");
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
               .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName ="IT";
        Department found = departmentService.getDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }
}