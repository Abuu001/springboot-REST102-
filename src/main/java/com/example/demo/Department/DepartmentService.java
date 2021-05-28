package com.example.demo.Department;

import com.example.demo.ErrorHandler.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
   public  Department saveDepartment(Department newDepartment);

   List<Department> getAllDepartments();

   void removeDeparment(Long departmentId);

   Department updateDepartment(Long departmentId, Department newDepartment);

   Department getDepartmentByName(String departmentName);

   Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
}
