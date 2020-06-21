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

}
