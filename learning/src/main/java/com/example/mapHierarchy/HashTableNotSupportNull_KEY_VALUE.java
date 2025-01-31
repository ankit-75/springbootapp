package com.example.mapHierarchy;

import java.util.Hashtable;

public class HashTableNotSupportNull_KEY_VALUE {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();

        // can not support null key and value
         hashtable.put(null, "A");   //  NullPointerException

         hashtable.put("A", null);     //   NullPointerException
    }
}
