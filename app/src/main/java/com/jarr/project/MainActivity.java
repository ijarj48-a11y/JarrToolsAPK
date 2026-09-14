package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    LinearLayout home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        home = new LinearLayout(this);
        home.setOrientation(LinearLayout.VERTICAL);
        home.setPadding(30, 50, 30, 30);
        home.setBackgroundColor(Color.rgb(8, 18, 35));

        TextView title = new TextView(this);
        title.setText("JARR TOOLS");
        title.setTextSize(30);
        title.setTextColor(Color.WHITE);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView subtitle = new TextView(this);
        subtitle.setText("Premium Tools & Anime");
        subtitle.setTextSize(16);
        subtitle.setTextColor(Color.LTGRAY);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 8, 0, 40);

        home.addView(title);
        home.addView(subtitle);

        Button tools = new Button(this);
        tools.setText("🛠 Jarr Tools");
        tools.setTextSize(18);
        tools.setOnClickListener(v -> openWebsite());

        Button anime = new Button(this);
        anime.setText("🎬 Anime");
        anime.setTextSize(18);
        anime.setOnClickListener(v -> {
            startActivity(new android.content.Intent(
                    MainActivity.this,
                    AnimeActivity.class
            ));
        });

        home.addView(tools);
        home.addView(anime);

        setContentView(home);
    }

    private void openWebsite() {
        android.webkit.WebView webView = new android.webkit.WebView(this);

        android.webkit.WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);

        webView.setWebViewClient(new android.webkit.WebViewClient());
        webView.loadUrl("https://jarr-tools.netlify.app");

        setContentView(webView);
    }
}
