package com.example.rxoperators.ObserObserver;

import java.util.List;
import io.reactivex.rxjava3.core.Observable;

//output

//s
//u
//n
//i
//s
//s
//u
//n
//n
//y

//It

public class ConcateMap {
    public static void main(String[] args){
        List<String> list =List.of("sun","is","sunny");

        Observable.fromIterable(list)
                .concatMap(e -> Observable.fromArray(e.split("")))
                .subscribe(System.out::println);

    }
}
