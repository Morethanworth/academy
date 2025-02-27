package com.ctw.workstation.javadvanced;

import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {
        List<String> listWords = List.of("Java", "FS", "Academy", "CTW", "BMW", "/", " - ");

        List<String> filterNonAlphabeticToUpper = listWords.stream().filter(word -> word.matches("[a-zA-Z]+")).
                map(String::toUpperCase).toList();
        System.out.println(filterNonAlphabeticToUpper);
    }
}
