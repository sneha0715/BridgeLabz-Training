package com.sneha;

import org.json.JSONObject;

class Car {
    private String brand;
    private String model;
    private int year;
    private double price;

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public JSONObject toJson() {
        JSONObject carJson = new JSONObject();
        carJson.put("brand", brand);
        carJson.put("model", model);
        carJson.put("year", year);
        carJson.put("price", price);
        return carJson;
    }
}

public class CarObjectToJson {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2022, 18500.50);
        JSONObject jsonObject = car.toJson();
        System.out.println(jsonObject);
    }
}

