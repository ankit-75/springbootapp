package com.example.collectionHierarchy;

import java.util.*;

public class IterableCollectionQueue {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();
        //queue.offer("a");
        //queue.add(null);
        System.out.println(queue);


        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addLast("a");
        deque.addLast("B");
       // deque.addLast(null);
        System.out.println(deque);

    }
}
