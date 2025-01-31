package com.example.java8;

import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfNNumbers {
    public static void main(String[] args) {
        int sum = IntStream.rangeClosed(1, 3).sum();
        System.out.println(sum);

        //"welcome to java" - find first repeated character using Stream functions

        String input = "welcome to java";
        Optional<Character> firstOcc =  input.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting() ))
                .entrySet().stream()
                .filter( entry -> entry.getValue()>1 )
                .map(entry -> entry.getKey())
                .findFirst();

        System.out.println(firstOcc);
    }
}

class A extends Exception{

}

class B extends A{

}
