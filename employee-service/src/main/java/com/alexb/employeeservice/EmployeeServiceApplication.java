package com.alexb.employeeservice;

import com.alexb.employeeservice.repository.DeptRepository;
import com.alexb.employeeservice.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceApplication {

    private final DeptRepository deptRepository;
    private final EmpRepository empRepository;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }
}
