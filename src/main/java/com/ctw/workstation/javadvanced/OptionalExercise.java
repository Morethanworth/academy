package com.ctw.workstation.javadvanced;

import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExercise {
    public static void main(String[] args) {
        String value = "RAFAEL";
        Optional<String> optionalvalue = Optional.of(value);
        //System.out.println(nullreference.orElseThrow(NullPointerException::new));
        Optional<Integer> length = Optional.of(optionalvalue.orElseThrow(NullPointerException::new).length());
        System.out.println(length.get());
    }
}
