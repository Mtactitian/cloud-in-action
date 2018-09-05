package com.alexb.employeeservice.repository;

import com.alexb.employeeservice.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmpRepository extends MongoRepository<Employee, String> {
    Employee findByName(String name);

    Optional<Employee> findByNumber(Integer number);
}
