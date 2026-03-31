package com.sneha;

import com.fasterxml.jackson.databind.ObjectMapper;

class Book {
    public String title;
    public String author;
    public int pages;
    public double price;
}

public class ValidateJsonStructure {
    public static void main(String[] args) {
        String json = "{\"title\":\"Clean Code\",\"author\":\"Robert Martin\",\"pages\":464,\"price\":45.99}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            Book book = mapper.readValue(json, Book.class);
            System.out.println("Valid JSON structure");
        } catch (Exception e) {
            System.out.println("Invalid JSON structure");
        }
    }
}
