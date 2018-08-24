package com.alexb.clientui.controller;

import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import com.alexb.clientui.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class BaseController {

    private final OrganizationService organizationService;

    @GetMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/employee")
    public EmployeeDto getEmployeeByName(@RequestParam(name = "ename") String employeeName) {
        return organizationService.getEmployee(employeeName);
    }

    @ResponseBody
    @GetMapping(value = "/dept")
    public DepartmentDto departmentByName(@RequestParam(name = "dname") String dname) {
        return organizationService.getDepartmentByName(dname);
    }
}
