package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout splash = new LinearLayout(this);
        splash.setOrientation(LinearLayout.VERTICAL);
        splash.setGravity(Gravity.CENTER);
        splash.setPadding(30, 30, 30, 30);

        GradientDrawable bg = new GradientDrawable(
                GradientDrawable.Orientation.TL_BR,
                new int[]{
                        Color.rgb(3, 18, 40),
                        Color.rgb(0, 76, 145),
                        Color.rgb(10, 35, 60)
                }
        );
        splash.setBackground(bg);

        TextView title = new TextView(this);
        title.setText("JARR TOOLS");
        title.setTextSize(30);
        title.setTextColor(Color.WHITE);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setLetterSpacing(0.12f);

        TextView collab = new TextView(this);
        collab.setText("× TAZEY");
        collab.setTextSize(18);
        collab.setTextColor(Color.rgb(255, 220, 60));
        collab.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        collab.setGravity(Gravity.CENTER);
        collab.setLetterSpacing(0.08f);

        TextView loading = new TextView(this);
        loading.setText("Preparing your tools...");
        loading.setTextSize(12);
        loading.setTextColor(Color.rgb(180, 215, 240));
        loading.setGravity(Gravity.CENTER);

        splash.addView(title);
        splash.addView(collab);

        LinearLayout.LayoutParams loadingParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        loadingParams.topMargin = 28;
        splash.addView(loading, loadingParams);

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
