package com.service.functionality.service;

import com.service.functionality.mapper.PeopleMapper;
import com.service.functionality.service.http.PeopleResponse;
import com.service.functionality.utils.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

class PeopleServiceTest {

    @Mock
    private PeopleMapper peopleMapper;

    @Mock
    private Util util;

    @InjectMocks
    private PeopleService sut;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void returnDescription() {
        String people = "Dani Sanchez";
        String expected = "Dani Sanchez";

        when(peopleMapper.descriptionPeople()).thenReturn(people);
        when(util.separateString(people)).thenReturn(expected);
        ResponseEntity<PeopleResponse> responseEntity = sut.descriptionPeople();

        assertThat(expected, is("Dani Sanchez"));
        assertThat(responseEntity.getStatusCode(), is (HttpStatus.OK));
    }
}