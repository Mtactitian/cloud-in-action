package com.alexb.employeeservice.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
public class UserContext {
    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static final String AUTH_TOKEN = "tmx-auth-token";

    private String correlationId = "";
    private String authToken = "";
    private String userId = "";
    private String orgId = "";
}