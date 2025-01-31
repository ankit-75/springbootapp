//package com.example.demo.powermocktest;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class ColloborateWithFinalMethodsJunit5Test {
//
//    @Test
//    void helloWorld() {
//        Mockito.mockStatic(ColloborateWithFinalMethodsJunit5.class);
//        Mockito.when(ColloborateWithFinalMethodsJunit5.secondMethod()).thenReturn("A");
//
//        String res = ColloborateWithFinalMethodsJunit5.secondMethod();
//
//        Assertions.assertEquals("A", res);
//    }
//
//
//
//    @Test
//    void finalMethodCaller() {
//        ColloborateWithFinalMethodsJunit5 colloborate =   Mockito.mock(ColloborateWithFinalMethodsJunit5.class);
//        Mockito.when(colloborate.finalMethod()).thenReturn("A");
//
//        String res = colloborate.finalMethod();
//        Assertions.assertEquals("A", res);
//    }
//
//    @Test
//    void firstMethod() {
//        ColloborateWithFinalMethodsJunit5 colloborate =   Mockito.mock(ColloborateWithFinalMethodsJunit5.class);
//        Mockito.when(colloborate.privateMethodCaller()).thenReturn("A");
//
//        String res = colloborate.privateMethodCaller();
//        Assertions.assertEquals("A", res);
//    }
//
//
//}