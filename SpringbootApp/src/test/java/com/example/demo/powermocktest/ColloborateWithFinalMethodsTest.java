package com.example.demo.powermocktest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.concurrent.Executor;
import java.util.random.RandomGeneratorFactory;

import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.example.demo.powermocktest.*")
public class ColloborateWithFinalMethodsTest {


    @Test
    public void helloWorld() throws Exception {


        String a = "";
        // crete mock object using powermock
        ColloborateWithFinalMethods mock =  mock(ColloborateWithFinalMethods.class);

        //when no constructor invoked
        whenNew(ColloborateWithFinalMethods.class).withNoArguments().thenReturn(mock);


        ColloborateWithFinalMethods colloborateWithFinalMethods = new ColloborateWithFinalMethods();
        when(colloborateWithFinalMethods.helloWorld()).thenReturn("Hello");

        //verify behaviour
        verifyNew(ColloborateWithFinalMethods.class).withNoArguments();


        String welcome = colloborateWithFinalMethods.helloWorld();

        Mockito.verify(colloborateWithFinalMethods).helloWorld();
        Assert.assertEquals("Hello", welcome);


    }

    @Test
    public void secondStaticMetods(){
         mockStatic(ColloborateWithFinalMethods.class);
         when(ColloborateWithFinalMethods.firstMethod(Mockito.anyString())).thenReturn("ANKIT");
         when(ColloborateWithFinalMethods.secondMethod()).thenReturn("KUMAR");


         String first = ColloborateWithFinalMethods.firstMethod("A");
         String second = ColloborateWithFinalMethods.secondMethod();

         Assert.assertEquals("ANKIT", first);
         Assert.assertEquals("KUMAR", second);

        verifyStatic(ColloborateWithFinalMethods.class, Mockito.times(1));
        ColloborateWithFinalMethods.firstMethod(Mockito.anyString());


    }

    @Test
    public void spyStaicTest(){

        spy(ColloborateWithFinalMethods.class);
        when(ColloborateWithFinalMethods.secondMethod()).thenReturn("A");

        String res = ColloborateWithFinalMethods.secondMethod();
        Assert.assertEquals("A", res);


    }

    @Test
    public void privateTest() throws Exception {
        ColloborateWithFinalMethods colloborate = new ColloborateWithFinalMethods();
        ColloborateWithFinalMethods mock = spy(colloborate);

        //mock private method
        when(mock,  "privateMethod").thenReturn("Pri");
        String returnValue = mock.privateMethodCaller();

        verifyPrivate(mock).invoke("privateMethod");
        Assert.assertEquals("Pri", returnValue);


        //mock final method
        when(mock.finalMethod()).thenReturn("A");
        String ret = mock.finalMethod();

        Mockito.verify(mock, Mockito.times(1)).finalMethod();
        Assert.assertEquals("A", ret);


    }
}