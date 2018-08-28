package com.alexb.employeeservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "emp")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empno")
    private Integer id;

    @Column(name = "ename")
    private String name;

    @Column(name = "sex")
    private Gender sex;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private Integer managerId;

    @Column(name = "hiredate")
    private LocalDate hireDate;

    @Column(name = "sal")
    private Double salary;

    @Column(name = "comm")
    private Double commission;

    @Column(name = "deptno")
    private Integer departmentNumber;
}