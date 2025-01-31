package com.example.reactive;

import java.util.stream.Stream;

public class StreamPullBase {
    public static void main(String[] args) {
       Stream.of(1,2,3, 4, 5, 6, 7, 8)
               .peek(element -> System.out.print("\nA"+element))
               .limit(4)
               .peek(element -> System.out.print("B"+element))
               .forEach(element -> System.out.print("C"+element));


    }
}
