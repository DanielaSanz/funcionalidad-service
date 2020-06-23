package com.service.functionality.util;

import com.service.functionality.model.People;
import com.service.functionality.service.http.PeopleRequest;
import com.service.functionality.service.http.PeopleResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UtilsTest {

    private String p1 = new String("Daniela,Sanchez");
    private String p2 = new String ("Reina,Marla");
    private String p3 = new String ("Polli,Manos");

    private PeopleRequest request = new PeopleRequest (Arrays.asList(p1, p2, p3));

    @BeforeEach
    public void setUp(){MockitoAnnotations.initMocks(this);}

    @Test
    public void separateFullName() {

        Utils sut = new Utils();

        ResponseEntity<PeopleResponse> responseEntity = sut.separateFullName(request);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));

        assertThat(responseEntity.getBody().getNameList().get(0).getName(), is("Daniela"));
        assertThat(responseEntity.getBody().getSurnameList().get(0).getSurname(), is("Sanchez"));

        assertThat(responseEntity.getBody().getNameList().get(1).getName(), is("Reina"));
        assertThat(responseEntity.getBody().getSurnameList().get(1).getSurname(), is("Marla"));

        assertThat(responseEntity.getBody().getNameList().get(2).getName(), is("Polli"));
        assertThat(responseEntity.getBody().getSurnameList().get(2).getSurname(), is("Manos"));
    }

}