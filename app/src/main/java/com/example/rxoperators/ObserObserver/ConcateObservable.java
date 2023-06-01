package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

//output

//Merge observable output is :src1: 0
//Merge observable output is :src1: 1
//Merge observable output is :src1: 2
//Merge observable output is :src1: 3
//Merge observable output is :src1: 4

//// In the above output you can see we are getting the emission sequentially from both observable
//// and there is  order between them like src1 should give emission first than src2 likewise.

public class ConcateObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> str1 = Observable.interval(1, TimeUnit.SECONDS).map(e -> "src1: "+e );
        Observable<String> str2 = Observable.interval(1,TimeUnit.SECONDS).map(e -> "src2 : "+e);

        Observable.concat(str1,str2)
                .subscribe(e-> System.out.println("Merge observable output is :"+e));

        Thread.sleep(5000);
    }
}
