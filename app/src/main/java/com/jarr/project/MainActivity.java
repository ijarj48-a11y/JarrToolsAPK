package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView splash = new TextView(this);
        splash.setText("JARR TOOLS");
        splash.setTextSize(30);
        splash.setTextColor(Color.WHITE);
        splash.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        splash.setGravity(Gravity.CENTER);
        splash.setBackgroundColor(Color.rgb(8, 18, 35));

        setContentView(splash);

        new android.os.Handler().postDelayed(() -> {
            WebView webView = new WebView(this);
            WebSettings settings = webView.getSettings();

            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);

            webView.setWebViewClient(new android.webkit.WebViewClient());
            webView.loadUrl("https://jarr-tools.netlify.app");

            setContentView(webView);
        }, 5000);
    }
}
