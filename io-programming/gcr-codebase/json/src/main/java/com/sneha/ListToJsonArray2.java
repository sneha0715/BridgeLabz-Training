package com.sneha;

import java.util.Arrays;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

class Product {
    public String name;
    public double price;
    public int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public class ListToJsonArray2 {
    public static void main(String[] args) throws Exception {

        List<Product> products = Arrays.asList(
                new Product("Laptop", 75000, 2),
                new Product("Mouse", 500, 5),
                new Product("Keyboard", 1200, 3)
        );

        ObjectMapper mapper = new ObjectMapper();
        String jsonArray = mapper.writeValueAsString(products);

        System.out.println(jsonArray);
    }
}
