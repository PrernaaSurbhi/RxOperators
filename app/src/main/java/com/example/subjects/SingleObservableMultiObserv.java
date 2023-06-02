package com.example.subjects;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

//output

//observ1 :10
//observ2 :10
//observ1 :18
//observ2 :18
//observ1 :20
//observ2 :20
//observ1 :5
//observ2 :5

public class SingleObservableMultiObserv  {
    public static void main(String [] args ) throws InterruptedException {
        Observable<Integer> src1 = Observable.just(10,18,20,5)
                .subscribeOn(Schedulers.computation());

        Subject<Object> subject = PublishSubject.create();

        subject.subscribe(e-> System.out.println("observ1 :"+e));

        subject.subscribe(e-> System.out.println("observ2 :"+e));

        src1.subscribe(subject);

        Thread.sleep(2000);

    }
}
