package com.example.demo;

interface A{
    void run();
}
public class Temp {
    public static void main(String[] args) {
        A a = () -> {
            System.out.println("Interface A");
        };
        a.run();

    }
}
