package com.example.rxoperators.ObserObserver;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

//amb - it used to remove duplicate emitting source coming from different observable source.

//output

//ob2 0
//ob2 1
//ob2 2
//ob2 3
//ob2 4

public class ambObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> ob1 = Observable.interval(1, TimeUnit.SECONDS)
                .take(5)
                .map(e -> "ob1 "+e);

        Observable<String> ob2 = Observable.interval(1, TimeUnit.MILLISECONDS)
                .take(5)
                .map(e -> "ob2 "+e);

        Observable.amb(Arrays.asList(ob1,ob2))
                .subscribe(System.out::println);


        Thread.sleep(10000);

    }
}
