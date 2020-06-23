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
        List<People> nameList = new ArrayList<>();
        List<People> surnameList = new ArrayList<>();

        for (int i = 0; i <request.getFullNameList().size() ; i++) {
            People p = new People();
            String string = request.getFullNameList().get(i);
            String[] parts = string.split(",");
            String part1 = parts[0];
            String part2 = parts[1];
            p.setName(part1);
            p.setSurname(part2);
            nameList.add(p);
            surnameList.add(p);
        }

        return ResponseEntity.ok(new PeopleResponse(nameList, surnameList));
    }
}
