package com.sneha;

import org.json.JSONObject;

public class MergeJsonObjects {
    public static void main(String[] args) {

        JSONObject obj1 = new JSONObject();
        obj1.put("name", "Sneha");
        obj1.put("age", 21);

        JSONObject obj2 = new JSONObject();
        obj2.put("email", "sneha@email.com");
        obj2.put("city", "Delhi");

        JSONObject merged = new JSONObject(obj1.toString());

        for (String key : obj2.keySet()) {
            merged.put(key, obj2.get(key));
        }

        System.out.println(merged.toString(2));
    }
}
