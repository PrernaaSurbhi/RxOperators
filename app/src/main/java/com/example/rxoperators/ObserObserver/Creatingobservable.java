package com.example.rxoperators.ObserObserver;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

//output of this file
//printing create observable
//10
//20

//printing Just observable
//1
//2
//3

//printing fromIterable observable
//prerna
//preeti
//mike

//printing defer observable
//prerna
//surbhi
//prerna
//surbhi
//newString

//printing range observable
//Recevied range : 2
//Recevied range : 3
//Recevied range : 4
//Recevied range : 5
//Recevied range : 6
//Recevied range : 7
//Recevied range : 8
//Recevied range : 9
//Recevied range : 10
//Recevied range : 11

public class Creatingobservable {

    public static void main(String[] args){

        //first method - create()
        Observable<Integer> createObservable = Observable.create(
                e -> {
                    e.onNext(10);
                    e.onNext(20);
                    e.onComplete();
                }
        );

        System.out.println(" ");
        System.out.println("printing create observable");

        createObservable.subscribe(System.out::println);

        System.out.println(" ");

        System.out.println("printing Just observable");

        //Second method using just oprator()
        Observable<Integer> justObservable = Observable.just(1,2,3);
        justObservable.subscribe(System.out::println);


        System.out.println(" ");

        System.out.println("printing fromIterable observable");
        //third operator from iterable
        List<String> list = List.of("prerna", "preeti", "mike");
        Observable<String> fromIterableObservable = Observable.fromIterable(list);

        fromIterableObservable.subscribe(System.out::println);

        //fourth method
        Observable.empty();
        //It will emit nothing but calls onComplete()

        //fifth method
        Observable.never();
        //It will emit nothing and also not call on onComplete method.

        //sixth method

        System.out.println(" ");

        System.out.println("printing defer observable");

        List<String> deferList = new ArrayList<>();
        deferList.add("prerna");
        deferList.add("surbhi");

        Observable<String> differObservable = Observable.defer(
                () -> Observable.fromIterable(deferList)
        );

        differObservable.subscribe(System.out::println);

        deferList.add("newString");
        differObservable.subscribe(System.out::println);

        System.out.println("");
        System.out.println("printing range observable");

        //seventh method
        //Observable.range(int startValue, int countValue)
        //it will print total 10 number starting from 2.
        Observable.range(2,10)
                .subscribe(s -> System.out.println("Recevied range : "+s));

    }
}
