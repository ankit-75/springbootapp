package com.example.collectionHierarchy;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class IterableCollectionSet {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("A");
        hashSet.add(null);
        boolean res = hashSet.remove("A");
        System.out.println(res);
        System.out.println(hashSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add(null);
        System.out.println(linkedHashSet);


        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("A");
        treeSet.add("B");
        treeSet.add("1");
        treeSet.add("0");

        System.out.println(treeSet);

    }
}
