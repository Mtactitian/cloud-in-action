package com.alexb.clientui.controller;

import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import com.alexb.clientui.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

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

    @GetMapping(value = "/employee/dept/{id}")
    @ResponseBody
    public List<EmployeeDto> getEmployees(@PathVariable(name = "id") Integer id) {
        return organizationService.getEmployees(id);
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus
    public void handleError(Throwable throwable) {
        log.error(throwable.getMessage());
    }
}
