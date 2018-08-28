package com.alexb.employeeservice.converters;

import com.alexb.employeeservice.dto.EmployeeDto;
import com.alexb.employeeservice.model.Employee;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class EmployeeToDtoConverter implements Converter<Employee, EmployeeDto> {
    @Override
    public EmployeeDto convert(Employee employee) {
        return new EmployeeDto(employee.getId(), employee.getName(), employee.getJob(), employee.getHireDate(), employee.getSalary(),
                employee.getSex().name());
    }
}