package com.example.rxoperators.ObserObserver;


import androidx.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Disposing {
    private static final CompositeDisposable disposable = new CompositeDisposable();
    public static void main(String[] args) throws InterruptedException {
        @NonNull
        Observable<Long> souceObservable = Observable.interval(1, TimeUnit.SECONDS);

        Disposable d1 =  souceObservable.subscribe(e-> System.out.println("observer1 "+e));
        Disposable d2 =  souceObservable.subscribe(e-> System.out.println("observer2 "+e));

        Thread.sleep(5000);

        disposable.addAll(d1,d2);

        disposable.dispose();

        Thread.sleep(10000);

    }
}
