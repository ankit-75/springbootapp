package com.example.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class FluxSubscriber implements Subscriber {
    @Override
    public void onSubscribe(Subscription subscription) {
        System.out.println("Inside onSubscribe");
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Inside onNext "+ o);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Inside onError");
    }

    @Override
    public void onComplete() {
        System.out.println("Inside onComplete");
    }
}
