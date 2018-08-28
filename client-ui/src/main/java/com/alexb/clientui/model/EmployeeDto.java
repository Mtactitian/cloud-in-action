package com.alexb.clientui.model;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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