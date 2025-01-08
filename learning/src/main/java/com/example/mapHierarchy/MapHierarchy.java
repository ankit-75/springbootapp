package com.example.mapHierarchy;

import java.util.*;

public class MapHierarchy {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A");
        String ret =  map.put(null, null);    System.out.println(ret);
        ret = map.put(null, "B");                 System.out.println(ret);
        ret = map.put(null, "D");                 System.out.println(ret);
        map.put("C", null);
        System.out.println(map);

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("a", "null");
        System.out.println(hashtable);

        System.out.println(Objects.hashCode("a"));


        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("A", "A");
        treeMap.put("1", "1");
        treeMap.put("C", "Z");
        treeMap.put("-1", "10");
        System.out.println(treeMap);

        Comparable<? super String> comparable = "A";
        int res = comparable.compareTo("B");
        System.out.println(res);
    }
}
