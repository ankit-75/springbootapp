package com.example.circulardep.setter;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClassC {
    ClassD classD;

    String name;

    public ClassC() {
        System.out.println("#####################  Constructor C");
    }

    @Autowired
    public void setClassD(ClassD classD){

        System.out.println("#####################  Class C setter setClassD ");
        this.classD = classD;
    }

    @PostConstruct
    void init(){
        System.out.println("#####################  Class C init ");
    }

    public ClassD getClassD() {
        System.out.println("#####################  Get Class D");
        return classD;
    }

    public void msg(){
        System.out.println("#####################  Class C msg ");
    }

    @PreDestroy
    void destroy(){
        System.out.println("#####################  Class C destroy");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("#####################  Class C setName");
        this.name = name;
    }
}
