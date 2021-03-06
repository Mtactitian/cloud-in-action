package com.alexb.employeeservice.service;

import com.alexb.employeeservice.annotation.Delay;
import com.alexb.employeeservice.annotation.Log;
import com.alexb.employeeservice.model.Employee;
import com.alexb.employeeservice.repository.DeptRepository;
import com.alexb.employeeservice.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmpRepository empRepository;
    private final DeptRepository deptRepository;

    @Delay(millis = 100)
    public Employee getEmployeeById(Integer empNumber) {
        return empRepository.findByNumber(empNumber)
                .orElseThrow(() -> new RuntimeException("Employee with given id has been not found"));
    }

    @Log(message = "Employee edited", level = "debug")
    public Employee editEmployeeInfo(Integer empNumber, Employee employeeDto) {
        Employee employee = empRepository.findByNumber(empNumber)
                .orElseThrow(() -> new RuntimeException("Employee with given name has been not found"));

        employee.setName(employeeDto.getName());
        employee.setJob(employeeDto.getJob());
        employee.setSalary(employeeDto.getSalary());
        employee.setHireDate(employeeDto.getHireDate());

        return empRepository.save(employee);
    }

    @Log(message = "Requested set of employees", level = "debug")
    public Set<Employee> getEmployeesByDeptNo(Integer deptNo) {
        return deptRepository.findByNumber(deptNo)
                .getEmployees();
    }
}
