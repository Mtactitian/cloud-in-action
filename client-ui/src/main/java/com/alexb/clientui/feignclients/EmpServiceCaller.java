package com.alexb.clientui.feignclients;

import com.alexb.clientui.model.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "employeeservice")
@RequestMapping(value = "/v1/employee")
public interface EmpServiceCaller {
    @GetMapping
    EmployeeDto getEmployee(@RequestParam(value = "ename") String employeeName);
}