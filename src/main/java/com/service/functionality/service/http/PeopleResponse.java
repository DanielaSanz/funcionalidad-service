package com.service.functionality.service.http;

import java.util.List;

import com.service.functionality.model.People;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PeopleResponse {

    private List<People> nameList;
    private List<People> surnameList;
    private String errorMessage;

    public PeopleResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public PeopleResponse(List<People> nameList, List<People> surnameList) {
        this.nameList = nameList;
        this.surnameList = surnameList;
    }
}
