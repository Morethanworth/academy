package com.ctw.workstation.javadvanced;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsApi {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("43", "21", "54", "89", "137", "142", "751", "89", "137");

        Set<Integer> numset = numbers.stream().map(Integer::parseInt).collect(Collectors.toSet());

        Map<String, Integer> groupedByEven = numset.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "even" : "odd"))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().mapToInt(Integer::intValue).sum()));
        System.out.println(groupedByEven);




    }
}
