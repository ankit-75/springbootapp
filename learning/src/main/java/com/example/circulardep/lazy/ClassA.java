package com.example.circulardep.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassA {
    ClassB classB;

    @Autowired
    public ClassA(ClassB classB) {
        System.out.println("****************  Constructor A");
        this.classB = classB;
    }

}
