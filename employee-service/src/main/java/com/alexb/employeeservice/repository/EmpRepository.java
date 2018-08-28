package com.alexb.employeeservice.repository;


import com.alexb.employeeservice.model.Employee;
import org.springframework.data.repository.Repository;

public interface EmpRepository extends Repository<Employee, Integer> {
    Employee findById(Integer id);
}
