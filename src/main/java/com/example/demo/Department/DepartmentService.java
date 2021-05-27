package com.example.demo.Department;

import java.util.List;

public interface DepartmentService {
   public  Department saveDepartment(Department newDepartment);

   List<Department> getAllDepartments();

   void removeDeparment(Long departmentId);

   Department updateDepartment(Long departmentId, Department newDepartment);

   Department getDepartmentByName(String departmentName);
}
