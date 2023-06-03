package com.example.subjects;

import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.Subject;

//output
//obser1 :anyTime
//observ2: anyTime

//Asyn subject - get the last emitted element.
//so both the observer get the last emitted element before onComplete() call.

public class AsynccSubject {
    public static void main(String[] args){
        Subject<String> asyncSubject = AsyncSubject.create();

        asyncSubject.subscribe(e-> System.out.println("obser1 :"+e));

        asyncSubject.onNext("work");
        asyncSubject.onNext("important");

        asyncSubject.subscribe(e-> System.out.println("observ2: "+e));

        asyncSubject.onNext("everyWhere");
        asyncSubject.onNext("anyTime");
        asyncSubject.onComplete();

    }
}
