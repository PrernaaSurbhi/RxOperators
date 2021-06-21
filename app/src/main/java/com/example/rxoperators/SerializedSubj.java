package com.example.rxoperators;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

// inorder to make subject , thread safety , it is good to add subject.toSerialized() method.


public class SerializedSubj {
    public static void main(String[] args) {

     //   PublishSubject  start subscribe from the time subscribe.

      PublishSubject<String> subject = PublishSubject.create();
      Subject<String> serializedSubject = subject.toSerialized();

      serializedSubject.subscribe(e -> System.out.println("observable1: "+e));
      serializedSubject.subscribe(e1 -> System.out.println("observable 2: "+e1));

      serializedSubject.onNext("Hello");
      serializedSubject.onNext("BasicStrong");
      serializedSubject.onComplete();

      serializedSubject.onNext("afterComplete");

    }

}
