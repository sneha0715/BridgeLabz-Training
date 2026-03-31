package com.sneha;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterUsersByAge {
    public static void main(String[] args) {

        String jsonData = "[{\"name\":\"Rahul\",\"age\":27},{\"name\":\"Neha\",\"age\":23},{\"name\":\"Vikram\",\"age\":31}]";

        JSONArray users = new JSONArray(jsonData);

        for (int i = 0; i < users.length(); i++) {
            JSONObject user = users.getJSONObject(i);
            if (user.getInt("age") > 25) {
                System.out.println(user.toString());
            }
        }
    }
}
