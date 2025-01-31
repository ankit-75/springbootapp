package com.example.interviewQ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class FinalClassTest {

    @BeforeAll
    public  static void  init(){

    }


    @Test
    void greet() {
        FinalClass finalClass =  Mockito.mock(FinalClass.class);
        Mockito.when(finalClass.greet()).thenReturn("Hell");

        assertEquals(finalClass.greet(), "Hell");
        Mockito.verify(finalClass, Mockito.times(1)).greet();
    }

    @Test
    void finalVariableTest() {
        FinalClass finalClass =  Mockito.mock(FinalClass.class);
        Mockito.when(finalClass.getFINAL_STRING()).thenReturn("Hell");

        assertEquals(finalClass.getFINAL_STRING(), "Hell");
        Mockito.verify(finalClass, Mockito.times(1)).getFINAL_STRING();
    }

    @Test
    void staticVariableTest() {
        FinalClass finalClass =  Mockito.mock(FinalClass.class);
        Mockito.when(finalClass.staticInFinalClass()).thenReturn("Hell");

        assertEquals(finalClass.staticInFinalClass(), "Hell");
        Mockito.verify(finalClass, Mockito.times(1)).staticInFinalClass();
    }
}