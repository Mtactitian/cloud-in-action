package com.alexb.clientui.client.feignclients;

import com.alexb.clientui.model.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "employeeservice")
@RequestMapping(value = "/v1/employee")
public interface EmpServiceCaller {

    @GetMapping(value = "/{id}")
    EmployeeDto getEmployee(@PathVariable(value = "id") Integer id);

    @PatchMapping(value = "/{id}")
    EmployeeDto editEmployee(@PathVariable(value = "id") Integer id, EmployeeDto employeeDto);
}