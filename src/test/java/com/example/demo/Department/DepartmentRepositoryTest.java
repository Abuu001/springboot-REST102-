package com.example.demo.Department;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //helps us to test our data with the db but after execution stops it flushes all test data from the db
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
      /*  Department department =
                Department.builder()
                .departmentName("Mechanical Engineer")
                .departmentCode("Me -0021")
                .departmentAddress("Delhi")
                .build();

        entityManager.persist(department);*/

     //   Department department = new Department(1L,"Mechanical Engineer","Delhi","Me -0021");

       // entityManager.persist(department);

    }

    @Test
    public void whenFindByID_thenReturnDepartment(){
      /*  Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(),"Mechanical Engineer");*/
    }
}