package com.example.demo.Department;

import com.example.demo.ErrorHandler.DepartmentNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    //logging
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
  public Department saveDepartment(@Valid @RequestBody Department newDepartment){
    LOGGER.info("..................Inside saveDepartment of DepartmentController....................");
    return departmentService.saveDepartment(newDepartment);
  }

  @GetMapping("/get/{departmentId}")
  public Department getDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
      return departmentService.getDepartmentById(departmentId);
  }

 @GetMapping
 public List<Department> fetchDepartmentList(){
     LOGGER.info("..................Inside getDepartments of DepartmentController....................");
    return departmentService.getAllDepartments();
 }

 @DeleteMapping("/remove/{departmentId}")
    public void deleteDepartment(@PathVariable("departmentId") Long departmentId){

     LOGGER.info("..................Inside deleteDepartment of DepartmentController....................");
        departmentService.removeDeparment(departmentId);
 }

    @PutMapping("/update/{departmentId}")
    public Department updateDepartment(
            @PathVariable("departmentId") Long departmentId,
            @RequestBody Department newDepartment
    ){

        LOGGER.info("..................Inside updateDepartment of DepartmentController....................");
       return departmentService.updateDepartment(departmentId,newDepartment);
    }

    @GetMapping("/name/{departmentName}")
    public Department getDepartmentByName(@PathVariable("departmentName") String departmentName){
        LOGGER.info("..................Inside getDepartmentByName of DepartmentController....................");
        return departmentService.getDepartmentByName(departmentName);
    }
}
