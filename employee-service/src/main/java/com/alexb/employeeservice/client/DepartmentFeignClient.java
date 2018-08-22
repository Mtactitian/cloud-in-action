package com.alexb.employeeservice.client;

import com.alexb.employeeservice.dto.DepartmentDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "departmentservice")
public interface DepartmentFeignClient {

    @GetMapping(value = "/alexb/v1/departments/{deptId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    DepartmentDto getDepartmentInfo(@PathVariable(value = "deptId") Integer deptId);
}
