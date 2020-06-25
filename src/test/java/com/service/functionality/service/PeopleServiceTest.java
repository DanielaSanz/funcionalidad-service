package com.service.functionality.service;

import com.service.functionality.model.People;
import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.util.Utils;
import com.service.functionality.util.ValidatorRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

class PeopleServiceTest {

    private String p1 = new String("Daniela,Sanchez");
    private String p2 = new String ("Reina,Marla");
    private String p3 = new String ("Polli,Manos");

    private PeopleRequest VALID_REQUEST = new PeopleRequest (Arrays.asList(p1, p2, p3));
    private PeopleRequest INVALID_REQUEST = new PeopleRequest(Collections.emptyList());


    private People people1 = new People("Daniela", "Sanchez");
    private People people2 = new People("Reina", "Marla");
    private People people3 = new People("Polli", "Manos");



    @Mock
    private Utils utils;

    @Mock
    private ValidatorRequest validatorRequest;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);}

    @Test
    @DisplayName("When No Exception is Caught. Should return 200 (OK)")
    public void separateFullName_ReturnTwoList_ReturnOk() {

        List<People> nameList = Arrays.asList(people1, people2, people3);
        List<People> surnameList = Arrays.asList(people1, people2, people3);

        PeopleService sut = new PeopleService(utils,validatorRequest);

        when(utils.apply(VALID_REQUEST)).thenReturn(ResponseEntity.ok(new PeopleResponse(nameList, surnameList)));

        ResponseEntity<PeopleResponse> responseEntity = sut.separateFullName(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

    }

    @Test
    @DisplayName("When utils throws Exception. Should return 204 (NO_CONTENT)")
    public void separateFullName_NoReturnList_ReturnNoContent() {
        PeopleService sut = new PeopleService(utils, validatorRequest);

        when(utils.apply(VALID_REQUEST)).thenReturn(ResponseEntity.noContent().build());

        ResponseEntity<PeopleResponse> responseEntity = sut.separateFullName(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NO_CONTENT));
    }

    @Test
    @DisplayName("When request is null Or Empty should return 400 (Bad Request)")
    public void separateFullName_requestNullOrEmpty_ReturnBadRequest() {
        PeopleService sut = new PeopleService(utils, validatorRequest);

        doThrow(IllegalArgumentException.class).when(utils).apply(INVALID_REQUEST);

        ResponseEntity<PeopleResponse> responseEntity = sut.separateFullName(INVALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    @Test
    @DisplayName("When separateFullName throws Exception. Should return 500 (Internal Server Error)")
    public void separateFullName_throwException_ReturnInternalServerError() {

        when(utils.apply(VALID_REQUEST)).thenThrow(new RuntimeException("Something bad happened"));

        PeopleService sut = new PeopleService(utils, validatorRequest);

        ResponseEntity<PeopleResponse> responseEntity = sut.separateFullName(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }

}