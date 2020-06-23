package com.service.functionality.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class ValidatorRequestTest {

    @InjectMocks
    private ValidatorRequest sut;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    private void validatorRequest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validatorRequest(null));
    }

}