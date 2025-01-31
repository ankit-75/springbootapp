package com.example.parallerStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        list.stream()
                .parallel()
               // .peek((e) -> System.out.println("Thread Name: " + Thread.currentThread().getName()))
                .sequential();
                //.forEach(System.out::println);
        //parallel streams are executed in parallel on multiple threads
        //The order of elements may not be preserved in parallel streams


        list.stream()
                .parallel()
                .peek((e) -> System.out.println("Thread Name: " + Thread.currentThread().getName()));
               // .forEachOrdered(System.out::println);
        //The order of elements may not be preserved in parallel streams
        //However, each thread will process a subset of the list, so the order of elements in the final result is not guaranteed to be the same as in the original list.

        //In this case, the order of elements is preserved in both parallel and sequential streams.


        // array list concurrent examples

        ArrayList<Integer> arrayList = new ArrayList<>();
        //List<Integer> arrayList = Collections.synchronizedList(arrayList2);


//        for (int i = 0; i < 5; i++) {
//            arrayList.clear();
//            Stream.iterate(1, (n) -> n<=30, n -> n+1)
//                    .parallel()
//                    .peek((e) -> System.out.println("Thread Name: " + Thread.currentThread().getName() +" val"+e))
//                    .forEach(arrayList::add);
//            System.out.println(arrayList);
//            //System.out.println(arrayList2);
//
//            System.out.println(arrayList.size());
//
//        }

        List<Integer> intList =  Stream.iterate(1, (n) -> n<=30, n -> n+1)
                .parallel()
                //.peek((e) -> System.out.println("Thread Name: " + Thread.currentThread().getName() +" val"+e))
                .collect(ArrayList::new, ArrayList::add,  (left, right) -> left.addAll(right) ) ;
        //.collect(Collectors.toList());
        System.out.println(intList);


    }
}
