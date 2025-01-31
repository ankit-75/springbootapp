package com.example.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FreqencyOfNumer {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        Map<Integer, Integer> numberRes = numbers.stream()
                .collect(Collectors.toMap(Function.identity(), val -> 1, (v1, v2) -> v1+v2));
        System.out.println(numberRes);

        List<String> words = Arrays.asList("car", "bike", "truck");
        List<String> wordsRes =  words.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(wordsRes);
    }
}
