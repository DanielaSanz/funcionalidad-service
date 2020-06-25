package com.service.functionality.util;

import com.service.functionality.model.People;
import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;

@Component
public class Utils implements Function<PeopleRequest, ResponseEntity<PeopleResponse>> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);

    @Override
    public ResponseEntity<PeopleResponse> apply(PeopleRequest request) {
        if(!request.getFullNameList().isEmpty()) {
            List<People> nameList = new ArrayList<>();
            List<People> surnameList = new ArrayList<>();

            for (int i = 0; i <request.getFullNameList().size() ; i++) {
                People p = new People();
                String string = request.getFullNameList().get(i);
                String[] parts = string.split(", ");
                String part1 = parts[0];
                String part2 = parts[1];
                p.setName(part1);
                p.setSurname(part2);
                nameList.add(p);
                surnameList.add(p);
            }
            LOGGER.info("Se devuelve lista de nombres y apellido por separado");
            return ResponseEntity.ok(new PeopleResponse(nameList, surnameList));
        }
        LOGGER.info("No es obtuvo la separación de lista");
        return ResponseEntity.noContent().build();
    }
}
