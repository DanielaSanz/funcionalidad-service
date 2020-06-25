package com.service.functionality.util;

import com.service.functionality.model.People;
import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UtilsTest {

    private String p1 = new String("Daniela, Sanchez");
    private String p2 = new String ("Reina, Marla");
    private String p3 = new String ("Polli, Manos");

    private PeopleRequest VALID_REQUEST = new PeopleRequest (Arrays.asList(p1, p2, p3));
    private PeopleRequest INVALID_REQUEST = new PeopleRequest(Collections.emptyList());

    @BeforeEach
    public void setUp(){MockitoAnnotations.initMocks(this);}

    @Test
    @DisplayName("When No Exception is Caught. Should return 200 (OK)")
    public void utils_returnTwoList_ReturnOK() {

        Utils sut = new Utils();

        ResponseEntity<PeopleResponse> responseEntity = sut.apply(VALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        assertThat(responseEntity.getBody().getNameList().get(0).getName(), is("Daniela"));
        assertThat(responseEntity.getBody().getSurnameList().get(0).getSurname(), is("Sanchez"));

        assertThat(responseEntity.getBody().getNameList().get(1).getName(), is("Reina"));
        assertThat(responseEntity.getBody().getSurnameList().get(1).getSurname(), is("Marla"));

        assertThat(responseEntity.getBody().getNameList().get(2).getName(), is("Polli"));
        assertThat(responseEntity.getBody().getSurnameList().get(2).getSurname(), is("Manos"));
    }

    @Test
    @DisplayName("When utils throws Exception. Should return 204 (NO_CONTENT)")
    public void utils_noReturnList_ReturnNoContent () {
        Utils sut = new Utils();

        ResponseEntity<PeopleResponse> responseEntity = sut.apply(INVALID_REQUEST);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.NO_CONTENT));
    }

}