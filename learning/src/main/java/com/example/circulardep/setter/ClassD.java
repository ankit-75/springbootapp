package com.example.circulardep.setter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ClassD {
   ClassC ClassC;

   String name;

    public ClassD() {
        System.out.println("#####################  Constructor D");
    }

    @Autowired
    public void setClassC(@Lazy ClassC ClassC){             // Setter Injection @lazy
        System.out.println("#####################  Class D setter setClassC");
        this.ClassC = ClassC;
    }

    @PostConstruct
    void init(){
        System.out.println("#####################  Class D init");
    }

    public ClassC getClassC() {
        System.out.println("#####################  Get Class C");
        return ClassC;
    }

    @PreDestroy
    void destroy(){
        System.out.println("#####################  Class D destroy");
    }

    public void msg(){
        System.out.println("#####################  Class D msg ");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("#####################  Class D setName");
        this.name = name;
    }
}
