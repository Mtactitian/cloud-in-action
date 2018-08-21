package com.alexb.employeeservice.controller;

import com.alexb.employeeservice.dto.UserInfo;
import com.alexb.employeeservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/alexb/info/department/{departmentId}/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final UserService userService;

    @RequestMapping(value = "/{employeeId}",
            method = RequestMethod.GET)
    public UserInfo getEmployeeWithDepartment(@PathVariable("departmentId") Integer departmentId,
                                              @PathVariable("employeeId") Integer employeeId) {
        return userService.getEmployeeWithDepartment(employeeId, departmentId);

    }
}
