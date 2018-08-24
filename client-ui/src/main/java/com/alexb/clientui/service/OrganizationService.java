package com.alexb.clientui.service;

import com.alexb.clientui.feignclients.DeptServiceCaller;
import com.alexb.clientui.feignclients.EmpServiceCaller;
import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final DeptServiceCaller deptServiceCaller;
    private final EmpServiceCaller empServiceCaller;

    public EmployeeDto getEmployee(String name) {
        return empServiceCaller.getEmployee(name);
    }

    public DepartmentDto getDepartmentById(Integer id) {
        return deptServiceCaller.getDepartmentById(id);
    }

    public DepartmentDto getDepartmentByName(String dname) {
        return deptServiceCaller.getDepartmentByName(dname);
    }
}
