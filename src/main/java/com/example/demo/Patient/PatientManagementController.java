package com.example.demo.Patient;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/patients")
@EnableGlobalMethodSecurity(prePostEnabled = true)  //tels our config we r goung to use ths mthds: hasAnyRole,hasAuthority
public class PatientManagementController {

    private static final List<Patient> PATIENTS = Arrays.asList(
            new Patient(1,"Naomi"),
            new Patient(2,"Abu"),
            new Patient(3,"James")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMIN_TRAINEE')")
    public List<Patient> getAllPatients(){
        return PATIENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('patient:write')")
    public void registerNewPatient(@RequestBody Patient patient){
        System.out.println("registerNewPatient >>>>>>");
        System.out.println(patient);
    }

    @DeleteMapping(path = "{patientId}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void deletePatient(@PathVariable("patientId") Integer patientId){
        System.out.println("deletePatient >>>>>>");
        System.out.println(patientId);
    }

    @PutMapping(path = "{patientId}")
    @PreAuthorize("hasAuthority('patient:write')")
    public void updatePatient(@PathVariable("patientId") Integer patientId,
                              @RequestBody Patient patient){
        System.out.println("updatePatient >>>>>>");
        System.out.println(String.format("%s %s" ,patientId,patient));
    }

}
