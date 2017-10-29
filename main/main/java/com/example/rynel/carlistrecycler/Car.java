package com.example.rynel.carlistrecycler;

/**
 * Created by rynel on 10/5/2017.
 */

public class Car {

    String car;
    String model;
    String type;

    public Car(String model, String type, String year) {

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    String year;

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
