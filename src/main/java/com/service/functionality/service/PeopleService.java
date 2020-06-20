package com.service.functionality.service;

import com.service.functionality.mapper.PeopleMapper;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleService {

    private final PeopleMapper peopleMapper;
    private final Util util;

    @Autowired
    public PeopleService(PeopleMapper peopleMapper, Util util) {
        this.peopleMapper = peopleMapper;
        this.util = util;
    }


    @GetMapping(
            value = "functionality/description",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PeopleResponse>descriptionPeople() {
        String people = peopleMapper.descriptionPeople();
        util.separateString(people);
        return ResponseEntity.ok(new PeopleResponse(people));
    }
}
