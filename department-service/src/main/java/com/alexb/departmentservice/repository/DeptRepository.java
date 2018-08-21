package com.alexb.departmentservice.repository;

import com.alexb.departmentservice.model.Department;
import org.springframework.data.repository.Repository;

public interface DeptRepository extends Repository<Department, Integer> {

    Department findById(Integer deptId);
}
