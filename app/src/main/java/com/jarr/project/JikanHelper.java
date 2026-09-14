package com.jarr.project;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class JikanHelper {

    public static String getTopAnime() {
        try {
            URL url = new URL("https://api.jikan.moe/v4/top/anime?limit=10");

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),
                            StandardCharsets.UTF_8)
            );

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            reader.close();
            conn.disconnect();

            return result.toString();

        } catch (Exception e) {
            return "";
        }
    }
}
