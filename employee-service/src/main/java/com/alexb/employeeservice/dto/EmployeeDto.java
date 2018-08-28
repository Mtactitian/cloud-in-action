package com.alexb.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeDto {

    private Integer id;

    private String name;

    private String job;

    private LocalDate hireDate;

    private Double salary;

    private String sex;

}