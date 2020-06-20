package com.service.functionality.utils;

import org.springframework.stereotype.Component;

@Component
public class Util {

    public String separateString(String description) {

        String string = description;
        String[] parts = string.split(" ");
        String part1 = parts[0];
        String part2 = parts[1];

        String result = part1+" " +part2;
        return result;
    }
}
