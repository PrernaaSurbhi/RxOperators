package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

//output

//
//4 obser1 0  obs2
//5 obser1 0  obs2
//6 obser1 0  obs2
//7 obser1 0  obs2
//8 obser1 0  obs2
//9 obser1 0  obs2
//9 obser1 1  obs2
//9 obser1 2  obs2
//9 obser1 3  obs2
//9 obser1 4  obs2
//9 obser1 5  obs2
//9 obser1 6  obs2
//9 obser1 7  obs2
//9 obser1 8  obs2
//9 obser1 9  obs2

public class CombineLatest {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> obser1 = Observable.interval(200, TimeUnit.MILLISECONDS).take(10);
        Observable<Long> obser2 = Observable.interval(1, TimeUnit.SECONDS).take(10);

        Observable.combineLatest(obser1,obser2,(e1,e2)-> e1+" obser1 "+e2+"  obs2" )
                .subscribe(System.out::println);

        Thread.sleep(10000);

    }
}
