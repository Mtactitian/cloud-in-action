package com.alexb.clientui.client;

import com.alexb.clientui.model.EmployeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class EmployeeServiceClient {

    private final RestTemplate restTemplate;

    public EmployeeDto getEmployee(Integer id) {
        ResponseEntity<EmployeeDto> response = restTemplate.exchange("http://employeeservice/v1/employee/{id}",
                HttpMethod.GET, null, EmployeeDto.class, id);
        return response.getBody();
    }

    public EmployeeDto editEmployee(Integer id, EmployeeDto employeeDto) {
        ResponseEntity<EmployeeDto> response = restTemplate.exchange("http://employeeservice/v1/employee/{id}", HttpMethod.PATCH,
                new HttpEntity<EmployeeDto>(employeeDto), EmployeeDto.class, id);
        return response.getBody();
    }
}
