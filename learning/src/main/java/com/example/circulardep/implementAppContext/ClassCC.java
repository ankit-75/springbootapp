package com.example.circulardep.implementAppContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ClassCC implements ApplicationContextAware, InitializingBean {
    private ApplicationContext applicationContext;
    private ClassDD classDD;

    public ClassCC() {
        System.out.println("$$$$$$$$$$$$$ Class CC");
    }




    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("$$$$$$$$$$$$$ afterPropertiesSetCC");
        classDD = applicationContext.getBean(ClassDD.class);
        classDD.setClassCC(this);
        System.out.println("$$$$$$$$$$$$$ "+classDD.messege());
    }

    public String messege(){
        return "ClassCC";
    }
}
