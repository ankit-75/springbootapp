package com.example.circulardep.postconstruct;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassAA {
    @Autowired
    ClassBB classBB;

    public ClassAA() {
        System.out.println("@@@@@@@@@@@@@@@@ ClassAA constructor");
    }

    @PostConstruct
    public void init(){
        System.out.println("@@@@@@@@@@@@@@@@ ClassAA init");
        classBB.setClassAA(this);
    }

    public void setClassBB(ClassBB classBB) {
        this.classBB = classBB;
    }
}
