package com.example.circulardep.implementAppContext;

import org.springframework.stereotype.Component;

@Component
public class ClassDD {
    ClassCC classCC;

    public ClassDD() {
        System.out.println("$$$$$$$$$$$$$ Class DD");
    }

    //@Autowired
    public void setClassCC(ClassCC classCC) {
        System.out.println("$$$$$$$$$$$$$ setClassCC");
        this.classCC = classCC;
    }

    public String  messege(){
        System.out.println("$$$$$$$$$$$$$ "+this.classCC);
        return "ClassDD";

    }}
