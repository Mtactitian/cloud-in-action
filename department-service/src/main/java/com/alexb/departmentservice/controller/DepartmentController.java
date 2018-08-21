package com.alexb.departmentservice.controller;

import com.alexb.departmentservice.model.Department;
import com.alexb.departmentservice.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/alexb/v1/departments")
@Slf4j
public class DepartmentController {

    private final DeptService deptService;

    @GetMapping(value = "{deptId}")
    public Department getDepartment(@PathVariable Integer deptId) {
        log.info("Request Processed!");
        return deptService.getDeptById(deptId);
    }

}