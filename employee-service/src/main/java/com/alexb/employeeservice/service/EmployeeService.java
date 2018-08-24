package com.alexb.employeeservice.service;

import com.alexb.employeeservice.model.Employee;
import com.alexb.employeeservice.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EmployeeService {
    private final EmpRepository empRepository;

    public Employee getEmployeeByName(String name) {
        return empRepository.findByName(name);
    }
}
