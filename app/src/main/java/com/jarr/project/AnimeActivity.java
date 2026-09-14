package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

public class AnimeActivity extends Activity {

    LinearLayout list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);

        list = new LinearLayout(this);
        list.setOrientation(LinearLayout.VERTICAL);
        list.setPadding(25, 25, 25, 25);
        list.setBackgroundColor(Color.rgb(8, 15, 28));

        TextView title = new TextView(this);
        title.setText("🎬 Jarr Tools Anime");
        title.setTextSize(26);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        title.setPadding(10, 20, 10, 30);

        list.addView(title);

        TextView loading = new TextView(this);
        loading.setText("Memuat anime...");
        loading.setTextSize(17);
        loading.setTextColor(Color.LTGRAY);
        loading.setGravity(Gravity.CENTER);
        list.addView(loading);

        scroll.addView(list);
        setContentView(scroll);

        new Thread(() -> loadAnime(loading)).start();
    }

    private void loadAnime(TextView loading) {
        try {
            URL url = new URL("https://graphql.anilist.co");

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);

            String query =
                    "{\"query\":\"query { Page(perPage: 20) { media(type: ANIME, sort: POPULARITY_DESC) { title { romaji } episodes averageScore } } }\"}";

            OutputStream os = conn.getOutputStream();
            os.write(query.getBytes(StandardCharsets.UTF_8));
            os.close();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder result = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            reader.close();
            conn.disconnect();

            String json = result.toString();

            runOnUiThread(() -> {
                list.removeView(loading);
                showAnime(json);
            });

        } catch (Exception e) {
            runOnUiThread(() ->
                    loading.setText("Gagal memuat anime: " + e.getMessage())
            );
        }
    }

    private void showAnime(String json) {

        Pattern pattern = Pattern.compile(
                "\"romaji\":\"(.*?)\".*?\"episodes\":(null|\\d+).*?\"averageScore\":(null|\\d+)"
        );

        Matcher matcher = pattern.matcher(json);

        int count = 0;

        while (matcher.find() && count < 20) {

            String animeTitle = matcher.group(1)
                    .replace("\\\"", "\"");

            String episodes = matcher.group(2).equals("null")
                    ? "Belum diketahui"
                    : matcher.group(2);

            String score = matcher.group(3).equals("null")
                    ? "Belum ada"
                    : matcher.group(3) + "/100";

            TextView card = new TextView(this);

            card.setText(
                    "🎞️ " + animeTitle +
                    "\nEpisode: " + episodes +
                    "\nScore: " + score
            );

            card.setTextSize(17);
            card.setTextColor(Color.WHITE);
            card.setPadding(25, 25, 25, 25);
            card.setBackgroundColor(Color.rgb(20, 35, 55));

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            -1,
                            -2
                    );

            params.setMargins(0, 0, 0, 18);

            list.addView(card, params);

            count++;
        }

        if (count == 0) {
            TextView error = new TextView(this);
            error.setText("Data anime tidak ditemukan.");
            error.setTextColor(Color.WHITE);
            error.setTextSize(17);
            list.addView(error);
        }
    }
}
