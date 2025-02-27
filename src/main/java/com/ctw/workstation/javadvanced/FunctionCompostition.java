package com.ctw.workstation.javadvanced;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionCompostition {
    public static void main(String[] args) {
        List<String> listWords = List.of("Java", "FS", "Academy", "CTW", "BMW", "/", " - ");

        //tudo junto
        List<String> filterNonAlphabeticToUpperEtc = listWords.stream().filter(word -> word.matches("[a-zA-Z]+")).
                map(String::toUpperCase).map(word -> "(" + word.length() + ")").collect(Collectors.toList());
        //System.out.println(filterNonAlphabeticToUpperEtc);


        //por funções
        Predicate<String> nonAlphabetic = word -> word.matches("[a-zA-Z]+");

        UnaryOperator<String> upperCase = String::toUpperCase;

        Function<String,Integer> getLength = String::length;

        Function<Integer,String> inBrackets = length -> "(" + length.toString() + ")";

        var composedFunction = upperCase.andThen(getLength).andThen(inBrackets);

        //System.out.println(listWords.stream().filter(nonAlphabetic).map(composedFunction).collect(Collectors.toList()));

        // Higher-Order Functions

        //tudo junto
        List<String> numbers = Arrays.asList("43", "21", "54", "89", "137", "142", "751", "89", "137");
        List<Integer> numbersSquared = numbers.stream().map(Integer::parseInt).map(x -> x * x).collect(Collectors.toList());
        System.out.println(numbersSquared);


        //separado
        Function<String,Integer> toInteger = Integer::parseInt;

        Function<String, Integer> squared = toInteger.andThen(x -> x * x);

        Function<List<String>, List<Integer>> toListsquared = x -> x.stream().map(squared).collect(Collectors.toList());

        System.out.println(toListsquared.apply(numbers));
    }
}
