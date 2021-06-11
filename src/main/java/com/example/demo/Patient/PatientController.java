package com.example.demo.Patient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    private static final List<Patient> PATIENTS = Arrays.asList(
            new Patient(1,"Naomi"),
            new Patient(2,"Abu"),
            new Patient(3,"James")
    );

    @GetMapping(path = "{patientId}")
    public Patient getPatient(@PathVariable("patientId") Integer patientId){
        return PATIENTS.stream()
                .filter(patient -> patientId.equals(patient.getPatientId()))
                .findFirst()
                .orElseThrow(()->new IllegalStateException("Patient " + patientId + " doesn't exist"));
    }

}
