package com.example.rxoperators;

//output

//A grade student mark is:80
//        A grade student mark is:90
//        A grade student mark is:76

//with sorted()
//A grade student mark is:76
//A grade student mark is:80
//A grade student mark is:90

import io.reactivex.rxjava3.core.Observable;

public class Operators {
    public static void main(String[] args){
        Observable<Integer> sourceObservable = Observable.just(20,80,60,90,30,76);

        sourceObservable.filter(e -> e>75)
                //sorted() sort the order in increasing way.
                .sorted()
                .subscribe(e -> System.out.println("A grade student mark is:"+e));
    }
}
