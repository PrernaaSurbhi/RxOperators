package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

//output

//here first subscription getting the data
//0
//1
//2
//3
//4
//5
//6
//7
//8
//9

// after 10 sec of sleep second subscription getting the data . As second subscription started after 10 sec it get data from 10 . So it is hot obsevable
//10
//10
//11
//11
//12
//12
//13
//13
//14
//14
//15
//15
//16
//16
//17
//17
//18
//18
//19
//19


public class HotObservable {
    public static void main(String[] args) throws InterruptedException {
     io.reactivex.rxjava3.observables.@NonNull ConnectableObservable<@NonNull Long> source  =  Observable.interval(1, TimeUnit.SECONDS).publish();
     //to fire the emission from connectable observables we can use ConnectableObservable.connect() method
        source.connect();
        source.subscribe(System.out::println);

        Thread.sleep(10000);
        source.subscribe(System.out::println);
        Thread.sleep(10000);
    }
}
