package com.sneha;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLCensorAnalyzer {

    public static void main(String[] args) throws Exception {
        censorJson();
        censorCsv();
    }

    static String mask(String name) {
        String[] parts = name.split(" ");
        return parts.length > 1 ? parts[0] + " ***" : "***";
    }

    static void censorJson() throws Exception {
        String content = new String(Files.readAllBytes(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\ipl_input.json")));
        JSONArray inputArray = new JSONArray(content);
        JSONArray outputArray = new JSONArray();

        for (int i = 0; i < inputArray.length(); i++) {
            JSONObject match = inputArray.getJSONObject(i);
            JSONObject out = new JSONObject();

            String t1 = match.getString("team1");
            String t2 = match.getString("team2");

            String m1 = mask(t1);
            String m2 = mask(t2);

            out.put("match_id", match.getInt("match_id"));
            out.put("team1", m1);
            out.put("team2", m2);

            JSONObject score = match.getJSONObject("score");
            JSONObject newScore = new JSONObject();
            newScore.put(m1, score.getInt(t1));
            newScore.put(m2, score.getInt(t2));

            out.put("score", newScore);
            out.put("winner", mask(match.getString("winner")));
            out.put("player_of_match", "REDACTED");

            outputArray.put(out);
        }

        Files.write(Paths.get("ipl_output.json"), outputArray.toString(2).getBytes());
    }

    static void censorCsv() throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("io-programming\\gcr-codebase\\json\\src\\main\\java\\com\\sneha\\ipl_input.csv"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("ipl_output.csv"));

        writer.write(lines.get(0));
        writer.newLine();

        for (int i = 1; i < lines.size(); i++) {
            String[] p = lines.get(i).split(",");
            writer.write(p[0] + "," + mask(p[1]) + "," + mask(p[2]) + "," +
                    p[3] + "," + p[4] + "," + mask(p[5]) + ",REDACTED");
            writer.newLine();
        }

        writer.close();
    }
}
