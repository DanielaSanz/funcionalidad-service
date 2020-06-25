package com.service.functionality.util;

import com.service.functionality.service.http.PeopleRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidatorRequest {

    public void validateRequest(PeopleRequest request) {
        validatorRequest(request);
        validatorListFullName(request.getFullNameList());
    }

    public static void validatorRequest(PeopleRequest request) {
        if(request == null)
            throw new IllegalArgumentException("El request no puede ser null");
    }

    public static void validatorListFullName (List<String> request) {

        PeopleRequest peopleRequest = new PeopleRequest(request);
        if(peopleRequest.getFullNameList() == null)
            throw new IllegalArgumentException("La lista no puede ser null");
        if(peopleRequest.getFullNameList().isEmpty())
            throw new IllegalArgumentException("La lista no puede ser vacia");

    }
}
