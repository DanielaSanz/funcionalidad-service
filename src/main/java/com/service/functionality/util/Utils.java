package com.service.functionality.util;

import com.service.functionality.model.People;
import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Utils {

    public ResponseEntity<PeopleResponse> separateFullName(PeopleRequest request) {
        People p1 = new People();
        List<People> nameList = new ArrayList<>();

        String string = request.getFullNameList().get(0);
        String[] parts = string.split(",");
        String part1 = parts[0];
        p1.setName(part1);
        nameList.add(p1);

        return ResponseEntity.ok(new PeopleResponse(nameList));
    }
}
