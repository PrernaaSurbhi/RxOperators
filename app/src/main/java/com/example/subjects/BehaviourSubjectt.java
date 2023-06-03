package com.example.subjects;

import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.Subject;

//output

//obser1 :work
//obser1 :important
//observ2: important
//obser1 :everyWhere
//observ2: everyWhere
//obser1 :anyTime
//observ2: anyTime

//note = In the behaviour subject - receive all emission with most recent one.
// So observ2 get the most recent one emission from obsr1 not all like replay subject.
public class BehaviourSubjectt {

    public static void main(String[] args){
        Subject<String> behaviourSubject = BehaviorSubject.create();

        behaviourSubject.subscribe(e-> System.out.println("obser1 :"+e));

        behaviourSubject.onNext("work");
        behaviourSubject.onNext("important");

        behaviourSubject.subscribe(e-> System.out.println("observ2: "+e));

        behaviourSubject.onNext("everyWhere");
        behaviourSubject.onNext("anyTime");
    }
}
