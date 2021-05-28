package com.example.demo.Department;

import com.example.demo.ErrorHandler.DepartmentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department newDepartment) {
        return departmentRepository.save(newDepartment);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void removeDeparment(Long departmentId) {

        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department newDepartment) {

        Department depDB = departmentRepository.findById(departmentId).get();

        //checking if its not null and not blank
        if(Objects.nonNull(newDepartment.getDepartmentName()) && !"".equalsIgnoreCase(newDepartment.getDepartmentName())){
            depDB.setDepartmentName(newDepartment.getDepartmentName());
        }

        if(Objects.nonNull(newDepartment.getDepartmentAddress()) && !"".equalsIgnoreCase(newDepartment.getDepartmentAddress())){
            depDB.setDepartmentAddress(newDepartment.getDepartmentAddress());
        }

        if(Objects.nonNull(newDepartment.getDepartmentCode()) && !"".equalsIgnoreCase(newDepartment.getDepartmentCode())){
            depDB.setDepartmentCode(newDepartment.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }
    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
      Optional<Department> department = departmentRepository.findById(departmentId);

      if(!department.isPresent()){
          throw new DepartmentNotFoundException("Department not available!!!");
      }

      return department.get();
    }

}
