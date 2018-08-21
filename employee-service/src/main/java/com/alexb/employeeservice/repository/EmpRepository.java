package com.alexb.employeeservice.repository;


import com.alexb.employeeservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
}
