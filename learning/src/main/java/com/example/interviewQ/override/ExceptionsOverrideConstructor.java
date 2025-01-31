package com.example.interviewQ.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsOverrideConstructor {
    public static void main(String[] args) throws Exception {
        Parent p = new Child();
        p.m1();
    }
}

//If parent constructor doesnt throw exception child class constructor cant throw any exception or not throw
// if parent constructor throws exception child class constructor can throw same or its super class exception
class ParentClass {

    ParentClass() throws FileNotFoundException {
        System.out.println("Parent constructor");
    }


}

class ChildClass extends Parent {

    ChildClass() throws IOException {
        System.out.println("Child constructor");
    }
}