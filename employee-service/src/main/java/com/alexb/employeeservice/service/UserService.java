package com.alexb.employeeservice.service;

import com.alexb.employeeservice.client.DepartmentDiscoveryClient;
import com.alexb.employeeservice.client.DepartmentFeignClient;
import com.alexb.employeeservice.dto.DepartmentDto;
import com.alexb.employeeservice.dto.EmployeeDto;
import com.alexb.employeeservice.dto.UserInfo;
import com.alexb.employeeservice.model.Employee;
import com.alexb.employeeservice.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final EmpRepository empRepository;
    private final DepartmentDiscoveryClient departmentDiscoveryClient;

    @Deprecated
    private final DepartmentFeignClient departmentFeignClient;

    public Employee getEmployee(Integer id) {
        return empRepository.getOne(id);
    }

    public UserInfo getEmployeeWithDepartment(Integer employeeId, Integer departmentId) {
        Employee employee = getEmployee(employeeId);

        EmployeeDto employeeDto = new EmployeeDto(employee.getName(), employee.getJob(), employee.getSalary());
        DepartmentDto departmentDto = departmentDiscoveryClient.getDepartmentInfo(departmentId);

        return new UserInfo(departmentDto, employeeDto);
    }
}
