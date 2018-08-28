package com.alexb.clientui.controller;

import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import com.alexb.clientui.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Slf4j
public class BaseController {

    private final OrganizationService organizationService;

    @GetMapping(value = "/")
    public String getIndexPage() {
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/employee/{id}")
    public EmployeeDto getEmployeeByName(@PathVariable(name = "id") Integer id) {
        return organizationService.getEmployee(id);
    }

    @ResponseBody
    @GetMapping(value = "/dept")
    public DepartmentDto departmentByName(@RequestParam(name = "dname") String dname) {
        return organizationService.getDepartmentByName(dname);
    }

    @PatchMapping(value = "/employee/{id}")
    @ResponseBody
    public EmployeeDto employeeDto(@PathVariable(name = "id") Integer id,
                                   @RequestBody EmployeeDto employeeDto) {
        return organizationService.editEmployee(id, employeeDto);
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus
    public void handleError(Throwable throwable) {
        log.error(throwable.getMessage());
    }
}
