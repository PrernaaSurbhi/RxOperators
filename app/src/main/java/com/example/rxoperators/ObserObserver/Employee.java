package com.example.rxoperators.ObserObserver;

public class Employee {

    int emp_id;
    String name;
    double rating;

    public Employee(int id, String name, double rating) {
        emp_id = id;
        this.name = name;
        this.rating = rating;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
