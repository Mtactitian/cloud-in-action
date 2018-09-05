package com.alexb.employeeservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "departments")
@AllArgsConstructor
@Data
public class Department {

    @Id
    private String id;

    private Integer number;

    private String name;

    private String location;

    @DBRef(lazy = true)
    private Set<Employee> employees;
}
