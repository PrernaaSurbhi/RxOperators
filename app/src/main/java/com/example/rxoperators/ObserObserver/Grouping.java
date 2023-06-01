package com.example.rxoperators.ObserObserver;

import io.reactivex.rxjava3.core.Observable;

public class Grouping {
    public static void main(String[] args){

        Observable<Employee> employeeObservable = Observable.just(
                new Employee(1,"prer",9.0),
                new Employee(2,"aaa",4.2),
                new Employee(3,"bb",9.0),
                new Employee(4,"cc",9.0),
                new Employee(5,"dd",4.2),
                new Employee(6,"ee",4.2),
                new Employee(7,"ff",4.2));

        employeeObservable.groupBy(e-> e.getRating())
                .flatMapSingle(e -> e.toList())
                .subscribe(System.out::println);

    }
}
