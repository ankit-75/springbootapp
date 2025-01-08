package com.example.circulardep.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClassB {
    ClassA classA;

    @Autowired
    public ClassB(@Lazy ClassA classA) {   // Lazy Initilization
        System.out.println("*****************  Constructor B");
        this.classA = classA;
    }
}
