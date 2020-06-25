package com.service.functionality.util;

import com.service.functionality.service.http.PeopleRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

class ValidatorRequestTest {

    @InjectMocks
    private ValidatorRequest sut;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("When request is null throw Illegal Argument Exception")
    public void validateRequest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validateRequest(null));
    }

    @Test
    @DisplayName("When listRequest is null throw Illegal Argument Exception")
    public void validatorRequest() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validatorRequest(null));
    }

    @Test
    @DisplayName("When listRequest is empty throw Illegal Argument Exception")
    public void validatorFullNameList() {
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validatorListFullName(null));
        Assertions.assertThrows(IllegalArgumentException.class, ()-> sut.validatorListFullName(Collections.EMPTY_LIST));
    }
}