package com.alexb.departmentservice.controller;

import com.alexb.departmentservice.model.Department;
import com.alexb.departmentservice.service.DeptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/departments")
@Slf4j
public class DepartmentController {
    private final DeptService deptService;

    @GetMapping(value = "/{deptId}")
    public Department getDepartmentById(@PathVariable Integer deptId) {
        log.info("Request Processed!");
        return deptService.getDeptById(deptId);
    }

    @GetMapping
    public Department getDepartmentByName(@RequestParam(value = "dname") String dname) {
        log.info("Request Processed!");
        return deptService.getDeptByName(dname);
    }
}