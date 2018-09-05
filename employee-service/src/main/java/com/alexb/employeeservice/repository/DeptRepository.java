package com.alexb.employeeservice.repository;

import com.alexb.employeeservice.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DeptRepository extends MongoRepository<Department, String> {
    Department findByName(String name);
    Department findByNumber(Integer number);

}
