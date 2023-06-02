package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

//output

//observer 1: 0
//observer 1: 1
//observer 1: 2
//observer 1: 3
//observer 1: 4
//observer 2: 4
//observer 1: 5
//observer 2: 5
//observer 1: 6
//observer 2: 6
//observer 1: 7
//observer 2: 7

//note - as on the below program observer2 comes after 5 sec ,but since replay(1) is added .
// so it cache the latest emission of previous subscription.So //observer 2: 4  comes into picture.


//observable.reply() - it will return connectable observable
//connectable observable .autoConnect() - it will return observable
public class Replaying {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> srcObservable = Observable.interval(1, TimeUnit.SECONDS)
                .replay(1,1,TimeUnit.SECONDS).
                        autoConnect();

        srcObservable.subscribe(e -> System.out.println("observer 1: "+e));

        Thread.sleep(5000);

        srcObservable.subscribe(e -> System.out.println("observer 2: "+e));

        Thread.sleep(3000);

    }
}
