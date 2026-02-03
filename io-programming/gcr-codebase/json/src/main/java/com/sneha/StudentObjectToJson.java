package com.sneha;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentObjectToJson {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "Sneha");
        student.put("age", 21);
        student.put("subjects", new JSONArray(new String[]{"Math", "Physics", "Computer Science"}));
        
        System.out.println(student);
    }
}
