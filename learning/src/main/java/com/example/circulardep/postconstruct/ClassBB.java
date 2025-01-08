package com.example.circulardep.postconstruct;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ClassBB {
    ClassAA classAA;

    public ClassBB() {
        System.out.println("@@@@@@@@@@@@@@@@ ClassBB constructor");
    }

    public void setClassAA(ClassAA classAA) {
        System.out.println("@@@@@@@@@@@@@@@@ ClassAA setter method in ClassBB ");
        this.classAA = classAA;
    }

    @PostConstruct
    void init(){
        System.out.println("@@@@@@@@@@@@@@@@ ClassBB init");
    }

    public String getMessege(){
        return "ClassBB";
    }
}
