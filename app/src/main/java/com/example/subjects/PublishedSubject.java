package com.example.subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;

//output
//obser1 :work
//obser1 :important
//obser1 :everyWhere
//observ2: everyWhere
//obser1 :anyTime
//observ2: anyTime

//note - As publish subject start receiving transmission at the time of subscription .
// So observer2 receive only "everyWhere" and "anyTime" and obsv1 receive all element emission.

public class PublishedSubject {
    public static void main(String [] args ) throws InterruptedException {
        PublishSubject<String> publishSubject = PublishSubject.create();

        publishSubject.subscribe(e-> System.out.println("obser1 :"+e));

        publishSubject.onNext("work");
        publishSubject.onNext("important");

        publishSubject.subscribe(e-> System.out.println("observ2: "+e));

        publishSubject.onNext("everyWhere");
        publishSubject.onNext("anyTime");

    }
}
