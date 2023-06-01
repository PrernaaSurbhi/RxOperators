package com.example.rxoperators.ObserObserver;


import java.util.List;

import io.reactivex.rxjava3.core.Observable;

//output

//h
//i
//f
//l
//a
//t
//m
//a
//p

public class Flatmap {
    public static void main(String[] args){
        List<String> list =List.of("hi","flat","map");

        Observable.fromIterable(list)
                .flatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

    }

}
