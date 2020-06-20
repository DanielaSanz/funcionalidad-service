package com.service.functionality.service;

import com.service.functionality.mapper.PeopleMapper;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.utils.Util;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);
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
    @ApiOperation("Separar string")
    public ResponseEntity<PeopleResponse> descriptionPeople() {
        try {
            String people = peopleMapper.descriptionPeople();
            util.separateString(people);
            LOGGER.info("Se separa string");
            return ResponseEntity.ok(new PeopleResponse(people));
        } catch (Exception ex){
            LOGGER.error("Ocurrio un error inesperado");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PeopleResponse(ex.getMessage()));
        }
    }
}
