package com.example.collectionHierarchy;

import java.util.*;


public class IterableCollectionList {
    public static void main(String[] args) {
        List<String>  arrayList = new ArrayList<>();
        //JAVA 21 sequencedCollection add, get, remove First and Last
        arrayList.add(null);
       // arrayList.addFirst("a");                 System.out.println(arrayList);
      //  String get = arrayList.getFirst();          System.out.println(get);
       // String remove = arrayList.removeFirst();     System.out.println(remove);


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("b");
        linkedList.add("b");
        linkedList.add(null);
        System.out.println(linkedList);


        Stack<String> stack = new Stack<>();
        stack.add("1");
        stack.add("2");
        stack.push("3");
        stack.push(null);
        stack.capacity();
        String res1 = stack.pop();
        System.out.println(stack);


        Vector<String> vector = new Vector<>();
        vector.add("1");
        vector.add(null);
        int capacity = vector.capacity();
        System.out.println(vector);
        System.out.println(capacity);


    }

}
