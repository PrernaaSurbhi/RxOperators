package com.example;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

//output

//TUESDAY Printed by : RxComputationThreadPool-1
//THRUSDAY Printed by : RxComputationThreadPool-1

//Note  - If there is more than one subscribeOn . Then subscribeOn nearer to the observable win.
public class MutilpleSubscribeOn {

    public static void main(String [] args) throws InterruptedException{
        Observable.just("Tuesday","sunday","Thrusday")
                .subscribeOn(Schedulers.computation())
                .map(e -> e.toUpperCase())
                .subscribeOn(Schedulers.newThread())
                .filter(e-> e.startsWith("T"))
                .subscribe(e-> print(e));

        Thread.sleep(3000);
    }

    public static void print(String element){
        System.out.println(element+" Printed by : "+Thread.currentThread().getName());
    }
}
