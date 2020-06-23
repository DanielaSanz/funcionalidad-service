package com.service.functionality.util;

import com.service.functionality.service.http.PeopleRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidatorRequest {

    public static void validatorRequest(PeopleRequest request) {
        if(request == null)
            throw new IllegalArgumentException("El request no puede ser null");
    }
}
