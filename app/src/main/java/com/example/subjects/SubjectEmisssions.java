package com.example.subjects;

import io.reactivex.rxjava3.subjects.PublishSubject;

//output

//observer1: prerna
//observer2: prerna
//observer1: smile
//observer2: smile

//note - in the below example hence  subject.onComplete() is called before  subject.onNext("hello").
//so "hello" is not getting printed in the output.

public class SubjectEmisssions {
    public static void main(String [] args ) throws InterruptedException {
        PublishSubject<String> subject = PublishSubject.create();

        subject.subscribe(e-> System.out.println("observer1: "+e));
        subject.subscribe(e-> System.out.println("observer2: "+e));

        subject.onNext("prerna");
        subject.onNext("smile");
        subject.onComplete();
        subject.onNext("hello");
    }
}
