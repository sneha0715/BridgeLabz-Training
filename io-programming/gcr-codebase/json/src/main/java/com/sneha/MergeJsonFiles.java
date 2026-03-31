package com.sneha;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MergeJsonFiles {

    public static void main(String[] args) throws IOException {

        String content1 = new String(Files.readAllBytes(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\file1.json")));
        String content2 = new String(Files.readAllBytes(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\file2.json")));

        JSONObject json1 = new JSONObject(content1);
        JSONObject json2 = new JSONObject(content2);

        for (String key : json2.keySet()) {
            json1.put(key, json2.get(key));
        }

        System.out.println("Merged JSON:");
        System.out.println(json1.toString(2)); 
    }
}
