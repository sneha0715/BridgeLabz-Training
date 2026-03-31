package com.sneha;

import org.json.JSONArray;
import org.json.JSONObject;

public class FilterByAge {
    public static void main(String[] args) {

        String jsonData = "[{\"name\":\"Arjun\",\"age\":28},{\"name\":\"Meera\",\"age\":22},{\"name\":\"Kabir\",\"age\":30}]";

        JSONArray people = new JSONArray(jsonData);
        JSONArray filtered = new JSONArray();

        for (int i = 0; i < people.length(); i++) {
            JSONObject person = people.getJSONObject(i);
            if (person.getInt("age") > 25) {
                filtered.put(person);
            }
        }

        System.out.println(filtered.toString(2));
    }
}
