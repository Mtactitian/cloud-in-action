package com.alexb.clientui.service;

import com.alexb.clientui.client.EmployeeServiceClient;
import com.alexb.clientui.client.feignclients.DeptServiceCaller;
import com.alexb.clientui.client.feignclients.EmpServiceCaller;
import com.alexb.clientui.model.DepartmentDto;
import com.alexb.clientui.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrganizationService {

    private final DeptServiceCaller deptServiceCaller;
    private final EmpServiceCaller empServiceCaller;

    /**
     * @deprecated
     */
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

    public List<EmployeeDto> getEmployees(Integer id) {
        log.debug("Requested Employees from given dept: {}", id);
        return empServiceCaller.getEmployees(id);
    }
}
