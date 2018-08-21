package com.alexb.employeeservice.client;

import com.alexb.employeeservice.dto.DepartmentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepartmentDiscoveryClient {

    private final RestTemplate restTemplate;

    public DepartmentDto getDepartmentInfo(Integer departmentId) {

        return restTemplate.exchange("http://departmentservice/alexb/v1/departments/{deptId}",
                HttpMethod.GET, null, DepartmentDto.class, departmentId)
                .getBody();

    }

}