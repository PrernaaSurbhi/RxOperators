package com.example.rxoperators.ObserObserver;


import androidx.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableCreate;

//output

//Observer with 3 parameter
// Prena
// surbhi
// Dev
//OnCompleted

//Observer with 2 parameter
// Prena
// surbhi
// Dev

//Observer with 1 parameter
// Prena
// surbhi
// Dev

public class CreatingObserver {

    public static void main(String [] args){

        Observable<Integer> observable = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(10);
                emitter.onNext(50);
                emitter.onComplete();
                emitter.onError(new Throwable());
            }
        });

        //First way of creating Observer by creating new Object of Observer

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("onNext");
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

      //  observable.subscribe((Consumer<? super Integer>) observer);

        System.out.println(" ");

        Observable<String> observableJust = Observable.just("Prena","surbhi","Dev");

        //another method of creating oberver by using optional lamda.
        //lamda with 3 parameter , onNext , onError, OnComplte.
        //lamda with 2 parameter , onNext ,onError.
        //lamda with 1 parameter, onNext.

        System.out.println("Observer with 3 parameter");
        observableJust.subscribe(i-> System.out.println(" "+i),Throwable:: printStackTrace,() -> System.out.println("OnCompleted"));

        System.out.println("Observer with 2 parameter");
        observableJust.subscribe(i-> System.out.println(" "+i),Throwable:: printStackTrace);


        System.out.println("Observer with 1 parameter");
        observableJust.subscribe(i-> System.out.println(" "+i));
    }
}
