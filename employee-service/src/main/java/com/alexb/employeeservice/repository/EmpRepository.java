package com.alexb.employeeservice.repository;


import com.alexb.employeeservice.model.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmpRepository extends Repository<Employee, Integer> {
    Employee findById(Integer id);

    List<Employee> findByDepartmentNumber(Integer departmentNumber);
}
