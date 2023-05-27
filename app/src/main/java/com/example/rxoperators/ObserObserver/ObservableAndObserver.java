package com.example.rxoperators.ObserObserver;

import android.database.Observable;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableCreate;

public class ObservableAndObserver {

   public static void main(String[] args){

//      Observable<Integer> observableSource = new ObservableCreate<Integer>(new ObservableOnSubscribe<Integer>() {
//         @Override
//         public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
//           try{
//              emitter.onNext(10);
//              emitter.onNext(11);
//              emitter.onComplete();
//           }catch (Throwable t){
//              emitter.onError(t);
//           }
//         }
//      });


       Observer<Integer> observer = new Observer<Integer>() {
           @Override
           public void onSubscribe(@NonNull Disposable d) {
               System.out.println("onSubscribe");
           }

           @Override
           public void onNext(@NonNull Integer integer) {
               System.out.println("onNext : "+integer);
           }

           @Override
           public void onError(@NonNull Throwable e) {
               e.printStackTrace();
           }

           @Override
           public void onComplete() {
               System.out.println("onComplete");
           }
       };

    //   observableSource.subscribe(observer);

   }

}
