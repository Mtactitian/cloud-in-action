package com.alexb.employeeservice.controller;

import com.alexb.employeeservice.model.Employee;
import com.alexb.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public Employee getEmployee(@RequestParam("ename") String employeeName) {
        return employeeService.getEmployeeByName(employeeName);
    }
}
