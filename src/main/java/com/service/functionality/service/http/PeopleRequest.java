package com.service.functionality.service.http;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeopleRequest {

    private List<String> fullNameList;
}
