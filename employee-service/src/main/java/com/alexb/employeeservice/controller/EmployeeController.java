package com.alexb.employeeservice.controller;

import com.alexb.employeeservice.dto.EmployeeDto;
import com.alexb.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping(value = "/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity editEmployee(@PathVariable(value = "id") Integer id,
                                       @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.editEmployeeInfo(id, employeeDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getEmployee(@PathVariable(value = "id") Integer id) {
        log.info("Request Processed");
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @GetMapping(value = "/dept/{id}")
    public ResponseEntity getEmployeesByDeptNo(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(employeeService.getEmployeesByDeptNo(id));
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleError(Exception ex) {
        log.error(ex.getMessage());
    }
}
