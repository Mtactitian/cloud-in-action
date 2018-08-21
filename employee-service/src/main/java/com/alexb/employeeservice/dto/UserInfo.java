package com.alexb.employeeservice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {
    private DepartmentDto department;
    private EmployeeDto employee;
}
