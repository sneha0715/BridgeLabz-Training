package com.sneha;

import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJsonFields {
    public static void main(String[] args) throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\Students.json")));
        JSONArray studentsArray = new JSONArray(content);

        for (int i = 0; i < studentsArray.length(); i++) {
            JSONObject student = studentsArray.getJSONObject(i);

            String name = student.getString("name");
            String email = student.getString("email");

            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println();
        }
    }
}
