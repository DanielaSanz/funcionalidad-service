package com.service.functionality.service.http;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeopleResponse {

    private String description;
    private String errorMessage;

    public PeopleResponse(String description) {
        this.description = description;
    }
}
