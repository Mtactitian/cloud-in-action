package com.alexb.departmentservice.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dept")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "deptno")
    private Integer id;

    @Column(name = "dname")
    private String name;

    @Column(name = "loc")
    private String location;

}