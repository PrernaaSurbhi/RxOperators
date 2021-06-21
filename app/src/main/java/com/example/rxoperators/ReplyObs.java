package com.example.rxoperators;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class ReplyObs {


    //replay operator  is powerful way to store previous element to certain scope.
    // it is useful for network call.

    public static  void main(String args[]) throws InterruptedException{

        Observable<Long> src = Observable.interval(1, TimeUnit.SECONDS)
                .replay()
                .autoConnect();


        src.subscribe(e -> System.out.println("observable 1: "+e));

        Thread.sleep(5000);

        src.subscribe(e -> System.out.println("obsevable 2:"+e));

        Thread.sleep(3000);
    }
}
