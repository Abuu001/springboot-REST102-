package com.example.demo.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    Department findByDepartmentName(String departmentName);
   /*
   ...IgnoreCase used for ignoring the case sensitivity hence can match small and capital letter

  @Query(value = "SELECT * FROM department WHERE departmentName = ?1", nativeQuery = true)
    Department findByDepartmentNameIgnoreCase(String departmentName);
   */
}
