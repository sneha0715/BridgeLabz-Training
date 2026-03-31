package com.sneha;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadJsonKeysValues {
    public static void main(String[] args) throws Exception {

        String content = new String(Files.readAllBytes(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\Students.json")));
        JSONArray jsonArray = new JSONArray(content);

        for(int i=0;i<jsonArray.length();i++){
            JSONObject obj =jsonArray.getJSONObject(i);
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                Object value = obj.get(key);
                System.out.println(key + " : " + value);
            }
        }

    }
}
