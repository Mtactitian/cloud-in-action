package com.alexb.clientui.client.feignclients;

import com.alexb.clientui.model.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "departmentservice")
@RequestMapping(value = "/v1/departments")
public interface DeptServiceCaller {
    @GetMapping(value = "/{deptId}")
    DepartmentDto getDepartmentById(@PathVariable(value = "deptId") Integer deptId);

    @GetMapping
    DepartmentDto getDepartmentByName(@RequestParam(value = "dname") String dname);
}
