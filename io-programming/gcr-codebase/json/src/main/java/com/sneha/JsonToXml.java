package com.sneha;

import org.json.JSONObject;
import org.json.XML;

public class JsonToXml {
    public static void main(String[] args) {

        String jsonData = "{ \"name\":\"Sneha\", \"age\":22, \"city\":\"Pune\" }";

        JSONObject jsonObject = new JSONObject(jsonData);

        String xmlData = XML.toString(jsonObject);

        System.out.println("<root>  " + xmlData + "  </root>");
        

    }
}
