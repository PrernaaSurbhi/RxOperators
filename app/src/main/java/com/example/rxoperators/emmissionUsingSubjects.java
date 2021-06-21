package com.example.rxoperators;

import io.reactivex.subjects.PublishSubject;

public class emmissionUsingSubjects {

    public static void main(String [] args){
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(e ->System.out.println("observable1: "+e));

        subject.subscribe(e ->System.out.println("observable2:  "+e));

        subject.onNext("Hello");
        subject.onNext("basicStrong");

        subject.onComplete();

        // since onComp already call out . the below onNext will be never used .
        subject.onNext("hi after complete ");
    }

}
