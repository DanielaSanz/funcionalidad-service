package com.service.functionality.service;

import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.util.Utils;
import com.service.functionality.util.ValidatorRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);
    private final Utils utils;
    private final ValidatorRequest validatorRequest;

    @Autowired
    public PeopleService(Utils utils, ValidatorRequest validatorRequest) {
        this.utils = utils;
        this.validatorRequest = validatorRequest;
    }

    public ResponseEntity<PeopleResponse> separateFullName(PeopleRequest request) {
        try {
            validatorRequest.validatorRequest(request);
            ResponseEntity<PeopleResponse> responseEntity = utils.separateFullName(request);
            LOGGER.info("Se devuelve lista de nombres y apellido por separado");
            return ResponseEntity.ok().body(new PeopleResponse());
        } catch (IllegalArgumentException iae) {
            LOGGER.info("Se devuelve lista de nombres y apellido por separado");
            return ResponseEntity.badRequest().body(new PeopleResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("Ocurrio un error al intentar obtener las listas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PeopleResponse(ex.getMessage()));
        }

    }

}
