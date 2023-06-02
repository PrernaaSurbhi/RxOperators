package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;
import io.reactivex.rxjava3.core.Observable;

//It work similar like reply() method cache and store recently send data .
// Only differ is Observable.cache- return observable not connectable observable.

//output

//observer 1: 0
//observer 1: 1
//observer 1: 2
//observer 1: 3
//observer 2: 0
//observer 2: 1
//observer 2: 2
//observer 2: 3
//observer 1: 4
//observer 2: 4
//observer 1: 5
//observer 2: 5
//observer 1: 6
//observer 2: 6
//observer 1: 7
//observer 2: 7

public class Caching {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> srcObservable = Observable.interval(1, TimeUnit.SECONDS)
                .cache();


        srcObservable.subscribe(e -> System.out.println("observer 1: "+e));

        Thread.sleep(5000);

        srcObservable.subscribe(e -> System.out.println("observer 2: "+e));

        Thread.sleep(3000);

    }
}
