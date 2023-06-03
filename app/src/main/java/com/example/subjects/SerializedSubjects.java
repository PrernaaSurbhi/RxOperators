package com.example.subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

//output
//oberv1: hello
//oberv2: hello
//oberv1: weather
//oberv2: weather

//note - in the below example publishSubject.toSerialized() method is called to make subject thread safe.

public class SerializedSubjects {
    public static void main(String [] args ) throws InterruptedException {
        PublishSubject<String> publishSubject = PublishSubject.create();

        Subject<String> serializedSubject = publishSubject.toSerialized();

        serializedSubject.subscribe(e-> System.out.println("oberv1: "+e));
        serializedSubject.subscribe(e-> System.out.println("oberv2: "+e));

        serializedSubject.onNext("hello");
        serializedSubject.onNext("weather");
        serializedSubject.onComplete();
    }
}
