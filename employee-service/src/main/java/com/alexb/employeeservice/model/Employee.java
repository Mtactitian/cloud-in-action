package com.alexb.employeeservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "employees")
@Builder
public class Employee {

    @Id
    private String id;

    private Integer number;

    private String name;

    private Gender gender;

    private String job;

    private LocalDate hireDate;

    private Double salary;

    private Double commission;

}