package com.example.rxoperators.ObserObserver;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class ObservableVariants {
    public static void main(String[] args){

        Observable<String> sourceObservable = Observable.just("Prerna","will","be");
        Observable<String> emptyObservable = Observable.just("");

        //Observable.first() .It will return Single<T> , Single type observable
        sourceObservable.first("Name")
                .subscribe(System.out::println);

        //Single observable

        Single.just("hello").subscribe(System.out::println);

        //Obsevable.firstElement() . It return Maybe<T> .
        sourceObservable.
                firstElement().
                subscribe(System.out::println);

        System.out.println("Maybe where empty observable");

        emptyObservable.firstElement().subscribe(System.out::println,
                e -> e.printStackTrace(),
                () -> System.out.println("Oncompleted"));

    }
}
