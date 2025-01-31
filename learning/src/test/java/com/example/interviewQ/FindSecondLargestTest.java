package com.example.interviewQ;

import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class FindSecondLargestTest {
    private MockedStatic<FindSecondLargest> mockedStatic;

    @BeforeAll  // class level setup, execute once, should be static
    static void  setup(){
        System.out.println("@BeforeAll");

    }

    @BeforeEach  // method level setup
    void setupThis(){
        System.out.println("@BeforeEach");
        mockedStatic =   Mockito.mockStatic(FindSecondLargest.class);
    }



    @Test
    void staticNoArgsReturnStringTest(){
       // try(MockedStatic<FindSecondLargest> findSecondLargestMockedStatic =   Mockito.mockStatic(FindSecondLargest.class)){
            // No args Static
            mockedStatic.when(FindSecondLargest::staticNoArgsReturnString).thenReturn("ANK");
            assertEquals(FindSecondLargest.staticNoArgsReturnString(), "ANK");
       // }


            mockedStatic.verify(FindSecondLargest::staticNoArgsReturnString, Mockito.times(1));

            assertTrue(Mockito.mockingDetails(FindSecondLargest.class).isMock());
            assertFalse(Mockito.mockingDetails(FindSecondLargest.class).isSpy());
    }

    @Test
    void staticOneArgsReturnStringTest(){
       // MockedStatic<FindSecondLargest> findSecondLargestMockedStatic =  Mockito.mockStatic(FindSecondLargest.class);
       //
        mockedStatic.when( () -> {
            FindSecondLargest.staticOneArgsReturnString(any(String.class)) ;
        }).thenReturn("B");


        assertEquals(FindSecondLargest.staticOneArgsReturnString("BB"), "B");

        mockedStatic.verify(() -> FindSecondLargest.staticOneArgsReturnString("BB"), Mockito.times(1));

    }

    @Test
    void staticOneArgsReturnVoidTest(){
        // MockedStatic<FindSecondLargest> findSecondLargestMockedStatic =  Mockito.mockStatic(FindSecondLargest.class);
        //
        mockedStatic.when( () -> {
            FindSecondLargest.staticOneArgsReturnString(any(String.class)) ;
        }).thenReturn("B");
        assertEquals(FindSecondLargest.staticOneArgsReturnString("BB"), "B");
    }




    @AfterEach
    void tearThis(){
        System.out.println("@AfterEach ---");
        mockedStatic.close();
    }

    @AfterAll
    static void tear(){
        System.out.println("@AfterAll");
    }

}