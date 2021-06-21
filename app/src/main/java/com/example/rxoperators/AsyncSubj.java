package com.example.rxoperators;

import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.Subject;

//AsyncSubject -- it used to get recent data before completion .


public class AsyncSubj {

    public static void main(String[] args) {

        //   ReplaySubject get all data , regardless of the time it subscribe.

        Subject<String> subject = AsyncSubject.create();
        Subject<String> serializedSubject = subject.toSerialized();

        serializedSubject.subscribe(e -> System.out.println("observable1: "+e));

        serializedSubject.onNext("a");
        serializedSubject.onNext("B");

        serializedSubject.subscribe(e2 -> System.out.println("observable 2: "+e2));

        serializedSubject.onNext("H");
        serializedSubject.onNext("i");
        //in AsyncSubject -- onComplete() should always call , except it u will not get any value
        serializedSubject.onComplete();
    }
}

////out put for above  code is
////    observable1: i
////    observable 2: i
