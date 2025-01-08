package com.example;

import com.example.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {

        HashMap<TestObject, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= 32; i++) {
            hashMap.put(new TestObject(i), i);
            if(i%4==0)
               System.out.println(hashMap);
        }


        A a = new C();
        a.method();



        String s1 = new String("GFG");

        // S2 refers to object in the Heap (after concat)
        String s2 = s1.concat("GFG");

        // S3 refers to object in SCP Area after intern()
        String s3 = s2.intern();

        System.out.println(s2 == s3);


        ///////////////////////
        String s11 = "100";
        Integer in = 100;

        String s22 = in.toString().intern();

        System.out.println(s11==s22);
        System.out.println(s11.equals(s22));

        ConfigurableApplicationContext run = SpringApplication.run(AppConfig.class);
        System.out.println(run);


        String[] beanDefinitionNames = run.getBeanFactory().getBeanDefinitionNames();

        for (String beanDef : beanDefinitionNames){
            System.out.println(beanDef);
        }

    }
}


class A{
    public static void method(){
        System.out.println("method inside A");
    }
}

class B{
   // @Override
    public static void method(){
        System.out.println("method inside B");
    }
}

class C extends A{

    public static void method(){
        System.out.println("method inside C");
    }


}