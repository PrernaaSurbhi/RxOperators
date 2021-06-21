package com.example.rxoperators;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class Subjects {

    public static void main(String [] args ){

        Observable<Integer> src1 = Observable.just(10,18,20,5);
        Observable<Integer> src2 = Observable.just(50,90,20);


        // for creating the subject , we need PublishSubject.create() call

        Subject<Object> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));

        src1.subscribe(subject);
        src2.subscribe(subject);

    }
}
