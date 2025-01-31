package com.example.demo.powermocktest;

public class ColloborateWithFinalMethods {
    public final String helloWorld(){
        return "Hellow World";
    }

    public final String finalMethod(){
        return "Final";
    }

    private String privateMethod(){
        return "Private";
    }
    String privateMethodCaller(){
        return privateMethod();
    }

    public static String firstMethod(String name){
        return "First "+name;
    }

    public static String secondMethod(){
        return "Second";
    }
}
