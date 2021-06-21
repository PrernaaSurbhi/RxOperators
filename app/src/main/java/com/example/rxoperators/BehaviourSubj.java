package com.example.rxoperators;

//Behaviour subject will get data from the time it subscribe .+ last recent element before its subscription.

import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class BehaviourSubj {
    public static void main(String[] args) {

        //   ReplaySubject get all data , regardless of the time it subscribe.

        Subject<String> subject = BehaviorSubject.create();
        Subject<String> serializedSubject = subject.toSerialized();

        serializedSubject.subscribe(e -> System.out.println("observable1: "+e));

        serializedSubject.onNext("Hello");
        serializedSubject.onNext("BasicStrong");

        serializedSubject.subscribe(e2 -> System.out.println("observable 2: "+e2));

        serializedSubject.onNext("He");
        serializedSubject.onNext("BS");

    }
}
