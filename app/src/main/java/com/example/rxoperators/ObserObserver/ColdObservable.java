package com.example.rxoperators.ObserObserver;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

//output

//printing list from first subscription
//        1
//        2
//        3

// printing list from second subscription
//        1
//        2
//        3
//        4

// we see the second subscription get the different data than first subscription . It is cold observable.

public class ColdObservable {

    public static  void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Observable<Integer> observable = Observable.fromIterable(list);

        System.out.println("printing list from first subscription");
        observable.subscribe(System.out::println);

        updateList(list);

        System.out.println("printing list from second subscription");
        observable.subscribe(System.out::println);
    }

    public static List<Integer> updateList( List<Integer> list){
        list.add(4);
        return list;
    }
}
