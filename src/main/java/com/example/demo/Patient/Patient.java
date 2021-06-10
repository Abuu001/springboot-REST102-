package com.example.demo.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Patient {

    private final Integer patientId;
    private final String patientName;

}
