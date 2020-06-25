package com.service.functionality.service;

import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.util.ValidatorRequest;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.function.Function;

@RestController
public class PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);
    private final Function<PeopleRequest,ResponseEntity<PeopleResponse>> utils ;
    private final ValidatorRequest validateRequest;

    @Autowired
    public PeopleService(Function<PeopleRequest,ResponseEntity<PeopleResponse>> utils
            , ValidatorRequest validateRequest) {
        this.utils = utils;
        this.validateRequest = validateRequest;
    }

    @GetMapping(
            value = "functionality/{PeopleRequest}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Obtener lista de nombres y apellidos")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se devuelve lista de nombres y apellido por separado", response = PeopleService.class),
            @ApiResponse(code = 204, message = "No es obtuvo la separación de lista", response = PeopleService.class),
            @ApiResponse(code = 400, message = "Argumentos inválidos", response = PeopleService.class),
            @ApiResponse(code = 500, message = "Error inesperado del servicio web", response = PeopleService.class)
    })
    public ResponseEntity<PeopleResponse> separateFullName(PeopleRequest request) {
        try {
            validateRequest.validateRequest(request);
            return Optional.ofNullable(utils.apply(request))
                    .orElseThrow(()-> new RuntimeException("Something bad happened"));
        } catch (IllegalArgumentException iae) {
            LOGGER.info("Se devuelve lista de nombres y apellido por separado");
            return ResponseEntity.badRequest().body(new PeopleResponse(iae.getMessage()));
        } catch (Exception ex) {
            LOGGER.error("Ocurrio un error al intentar obtener las listas");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PeopleResponse(ex.getMessage()));
        }

    }

}
