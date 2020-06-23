package com.service.functionality.util;

import com.service.functionality.service.http.PeopleRequest;
import org.springframework.stereotype.Component;

@Component
public class ValidatorRequest {

    public void validateRequest(PeopleRequest request) {
        validatorRequest(request);
        //validatorListFullName(request);
    }

    public void validatorRequest(PeopleRequest request) {
        if(request == null)
            throw new IllegalArgumentException("El request no puede ser null");
    }

    /*public void validatorListFullName (PeopleRequest request) {
        if(request.getFullNameList() == null)
            throw new IllegalArgumentException("La lista no puede ser null");
        if(request.getFullNameList().isEmpty())
            throw new IllegalArgumentException("La lista no puede ser vacia");

    }*/
}
