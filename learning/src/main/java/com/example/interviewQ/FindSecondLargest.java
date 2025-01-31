package com.example.interviewQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FindSecondLargest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5000,7000,6000,8000,7000,9000);
        System.out.println(list.parallelStream().findAny());
        secondLarge(list);
    }

    public static Optional<Integer>  secondLarge( List<Integer> list){
        //List<Integer> list = Arrays.asList(5000,7000,6000,8000,7000,9000);

        Optional<Integer> secondLast = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct()
                .skip(1)
                .limit(1)
                .findFirst();
        System.out.println(secondLast.orElseThrow());
        return secondLast;
    }

    public static String staticNoArgsReturnString(){
        return "Hello";
    }

    public static String staticOneArgsReturnString(String name){
        return "Hello "+ name;
    }

    public static void staticVoidTest(){

    }



}
