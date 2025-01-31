package com.example.reactive;

import reactor.core.publisher.Flux;

import java.util.stream.Stream;


public class ReactiveTest {
    Flux fluxString(int cases){

        return switch(cases){
            case 1 ->  {
                yield  Flux.just("a", "b", "c", "d").map( el -> el.toUpperCase()).log() ;
            }
            case 2 ->  Flux.error(new RuntimeException("Something went wrong")).log();
            default -> Flux.empty();
        };
    }

    public static void main(String[] args) {



        ReactiveTest reactiveTest = new ReactiveTest();

        Flux<String> stringFlux = reactiveTest.fluxString(1);
        //stringFlux.subscribe(new FluxSubscriber());
        stringFlux.subscribe(word -> {
                System.out.println("A - "+word);
                try{
                    Thread.sleep(1000);
                }
                catch(Exception e){}
            },
                            ex-> System.out.println("Ex"),
                            ()-> System.out.println("Completed")
        );

        stringFlux.subscribe(word -> System.out.println("B- "+word)
        );

    }
}
