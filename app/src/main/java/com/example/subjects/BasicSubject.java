package com.example.subjects;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

//output

//50
//90
//2
//10
//18
//20
//5

//Subjects are used to merge the subscription from the multi casting source.

public class BasicSubject {
    public static void main(String [] args ) throws InterruptedException {

        Observable<Integer> src1 = Observable.just(10,18,20,5)
                .subscribeOn(Schedulers.computation());

        Observable<Integer> src2 = Observable.just(50,90,2)
                .subscribeOn(Schedulers.computation());


        // for creating the subject , we need PublishSubject.create() call

        Subject<Object> subject = PublishSubject.create();

        subject.subscribe(e -> System.out.println(e));

        src1.subscribe(subject);
        src2.subscribe(subject);

        Thread.sleep(2000);

    }

}
