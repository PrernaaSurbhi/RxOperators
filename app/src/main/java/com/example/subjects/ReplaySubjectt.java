package com.example.subjects;

import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;

//output

//obser1 :work
//obser1 :important
//observ2: work
//observ2: important
//obser1 :everyWhere
//observ2: everyWhere
//obser1 :anyTime
//observ2: anyTime

//note - in the given example both observer get the all subscription as it is replay subject.
//replay subject = emit all the item of the source observable regardless of when the subscriber subscribe.

public class ReplaySubjectt {
    public static void main(String[] args){
        Subject<String> replaySubject = ReplaySubject.create();

        replaySubject.subscribe(e-> System.out.println("obser1 :"+e));

        replaySubject.onNext("work");
        replaySubject.onNext("important");

        replaySubject.subscribe(e-> System.out.println("observ2: "+e));

        replaySubject.onNext("everyWhere");
        replaySubject.onNext("anyTime");

    }
}
