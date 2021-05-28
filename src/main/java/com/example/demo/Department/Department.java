package com.example.demo.Department;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//@Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together:
@Entity //make this class interact with our db
@ToString // from lombok --- it adds an tostring override method
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message="please Add department name") // validating not to allow blank name
    //@Lenght(min=3)
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
