package com.service.functionality.utils;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class UtilTest {

    @InjectMocks
    private Util sut;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void separateDescription() {
        String description = "Daniela Sanchez";

        String string = sut.separateString(description);

        assertThat(string, is("Daniela Sanchez"));
    }
}