package com.alexb.employeeservice.client;

import com.alexb.employeeservice.dto.DepartmentDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepartmentDiscoveryClient {

    private final RestTemplate restTemplate;

    @HystrixCommand(commandProperties = {@HystrixProperty(
            name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "12500"), @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")},
            fallbackMethod = "fallBack")
    public DepartmentDto getDepartmentInfo(Integer departmentId) {

        return restTemplate.exchange("http://departmentservice/alexb/v1/departments/{deptId}",
                HttpMethod.GET, null, DepartmentDto.class, departmentId)
                .getBody();
    }


    private DepartmentDto fallBack(Integer departmentId) {
        log.error("Fallback executed...");
        return getDepartmentInfo(departmentId);
    }


    private void randomlyRunLong() {
        Random random = new Random();

        int randomInt = random.nextInt(2);

        try {
            Thread.sleep(randomInt * 1000);
        } catch (InterruptedException e) {
            log.error("Request failed");
        }
    }
}

