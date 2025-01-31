package com.example.interviewQ;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class StringQuestion {
    public static void main(String[] args) {
        String a = "ABC";
        System.out.println(a.hashCode());
        String b = new String("ABC");
        System.out.println(b.hashCode());

        String c = new String("ABC").intern();
        System.out.print("a == c ");
        System.out.println( a == c);
        System.out.print ("b == c " );
        System.out.println(b == c);


    }
}
