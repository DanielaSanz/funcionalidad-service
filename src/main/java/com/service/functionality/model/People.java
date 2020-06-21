package com.service.functionality.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class People {

    private String name;
    private String surname;

    public People(String name) {
        this.name = name;
    }

}
