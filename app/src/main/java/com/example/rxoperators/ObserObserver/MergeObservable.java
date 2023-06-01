package com.example.rxoperators.ObserObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;

//output

//Merge observable output is :src1: 0
//Merge observable output is :src2 : 0
//Merge observable output is :src1: 1
//Merge observable output is :src2 : 1
//Merge observable output is :src1: 2
//Merge observable output is :src2 : 2
//Merge observable output is :src1: 3
//Merge observable output is :src2 : 3
//Merge observable output is :src2 : 4
//Merge observable output is :src1: 4
//Merge observable output is :src2 : 5
//Merge observable output is :src1: 5
//Merge observable output is :src2 : 6
//Merge observable output is :src1: 6
//Merge observable output is :src1: 7
//Merge observable output is :src2 : 7
//Merge observable output is :src2 : 8
//Merge observable output is :src1: 8
//Merge observable output is :src1: 9
//Merge observable output is :src2 : 9

// In the above output you can see we are getting the emission from both observable
// and there is no order between them like src1 should give emission first than src2

public class MergeObservable {
    public static void main(String[] args) throws InterruptedException {
        Observable<String> str1 = Observable.interval(1, TimeUnit.SECONDS).map( e -> "src1: "+e );
        Observable<String> str2 = Observable.interval(1,TimeUnit.SECONDS).map(e -> "src2 : "+e);

        Observable.merge(str1,str2)
                .subscribe(e-> System.out.println("Merge observable output is :"+e));

        Thread.sleep(10000);
    }
}
