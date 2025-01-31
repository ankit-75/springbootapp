package com.example.interviewQ.override;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionsOverride {
    public static void main(String[] args) throws Exception {
        Parent p = new Child();
        p.m1();
        p.m3("s");
    }
}

//If parent method does not throw exception child also not throw checked exception (m2 method)
//If parent declare checked Exception, child should throw same or any subtype exception, or no exception thrown
class Parent {

Object m1 = new Object();
    public void m1() throws Exception {
        throw new IOException("Exception in Parent");
    }

    public void m2() {
        System.out.println("Parent class m2");
    }

    public String m3(String o)  {
        System.out.println("Parent class m3");
        return null;
    }
}



class Child extends Parent {

    public void m1() throws IOException{
        try{
            System.out.println("Child class m1");
            throw new IOException("");
        }catch(IOException e){

        }finally{

        }

    }


    public void m2() throws NullPointerException, ArithmeticException {
        System.out.println("Child class m2");
    }


    public String m3(String o) {
        System.out.println("Child class m3");
        return null;
    }
}

class Child2 extends Child{
    public void m1() throws FileNotFoundException{
        System.out.println("Child2 class m1");
    }
}