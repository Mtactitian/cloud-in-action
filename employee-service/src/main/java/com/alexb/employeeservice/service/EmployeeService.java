package com.alexb.employeeservice.service;

import com.alexb.employeeservice.annotation.RandomDelay;
import com.alexb.employeeservice.dto.EmployeeDto;
import com.alexb.employeeservice.model.Employee;
import com.alexb.employeeservice.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {

    private final ConversionService conversionService;
    private final EmpRepository empRepository;

    @RandomDelay(millis = 100)
    public EmployeeDto getEmployeeById(Integer id) {
        Employee employee = empRepository.findById(id);
        return conversionService.convert(Optional.ofNullable(employee)
                        .orElseThrow(() -> new EntityNotFoundException("Employee with given id has been not found")),
                EmployeeDto.class);
    }

    @Transactional
    public EmployeeDto editEmployeeInfo(Integer id, EmployeeDto employeeDto) {
        Employee employee = Optional.ofNullable(empRepository.findById(id))
                .orElseThrow(() -> new EntityNotFoundException("Employee with given name has been not found"));

        employee.setName(employeeDto.getName());
        employee.setJob(employeeDto.getJob());
        employee.setSalary(employeeDto.getSalary());
        employee.setHireDate(employeeDto.getHireDate());

        employeeDto.setId(id);

        return employeeDto;
    }

    public List<Employee> getEmployeesByDeptNo(Integer deptNo) {
        return empRepository.findByDepartmentNumber(deptNo);
    }
}
