package com.alexb.departmentservice.service;

import com.alexb.departmentservice.model.Department;
import com.alexb.departmentservice.repository.DeptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeptService {

    private final DeptRepository deptRepository;

    public Department getDeptById(Integer id) {
        return deptRepository.findById(id);
    }
}
