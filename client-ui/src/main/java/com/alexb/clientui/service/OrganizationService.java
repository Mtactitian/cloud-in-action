package com.alexb.clientui.service;

import com.alexb.clientui.client.EmployeeServiceClient;
import com.alexb.clientui.client.feignclients.DeptServiceCaller;
import com.alexb.clientui.client.feignclients.EmpServiceCaller;
import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final DeptServiceCaller deptServiceCaller;
    private final EmpServiceCaller empServiceCaller;

    @Deprecated
    private final EmployeeServiceClient employeeServiceClient;

    public EmployeeDto getEmployee(Integer id) {
        return empServiceCaller.getEmployee(id);
    }

    public DepartmentDto getDepartmentById(Integer id) {
        return deptServiceCaller.getDepartmentById(id);
    }

    public DepartmentDto getDepartmentByName(String dname) {
        return deptServiceCaller.getDepartmentByName(dname);
    }

    public EmployeeDto editEmployee(Integer id, EmployeeDto employeeDto) {
        return empServiceCaller.editEmployee(id, employeeDto);
    }
}
