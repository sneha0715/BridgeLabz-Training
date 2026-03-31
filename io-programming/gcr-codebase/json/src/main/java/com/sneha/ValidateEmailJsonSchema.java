package com.sneha;

import org.json.JSONObject;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.everit.json.schema.ValidationException;

public class ValidateEmailJsonSchema {
    public static void main(String[] args) {

        String schemaStr = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String jsonData = "{ \"email\": \"test@example.com\" }";

        JSONObject schemaJson = new JSONObject(schemaStr);
        JSONObject dataJson = new JSONObject(jsonData);

        Schema schema = SchemaLoader.load(schemaJson);

        try {
            schema.validate(dataJson);
            System.out.println("Valid email format");
        } catch (ValidationException e) {
            System.out.println("Invalid email format");
        }
    }
}
