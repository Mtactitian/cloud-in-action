package com.alexb.clientui.model;

import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class DepartmentDto {
    private Integer number;
    private String name;
    private String location;

}