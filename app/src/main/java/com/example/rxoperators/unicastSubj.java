package com.example.rxoperators;

// only one observer allow.
//it will buffer all the emmission received by source, until an observer subscribe  to it .

//o/p  java.lang.IllegalStateException: Only a single observer allowed. --- unicastObserver

import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;

public class unicastSubj {

    public static void main(String[] args) {

        //   ReplaySubject get all data , regardless of the time it subscribe.

        Subject<String> subject = UnicastSubject.create();
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
