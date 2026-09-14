package com.jarr.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int blue = Color.rgb(25, 118, 210);
    int darkBlue = Color.rgb(13, 55, 100);
    int bg = Color.rgb(248, 251, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(bg);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(24, 35, 24, 30);

        // Header
        TextView logo = new TextView(this);
        logo.setText("JP");
        logo.setTextColor(Color.WHITE);
        logo.setTextSize(29);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        logo.setGravity(Gravity.CENTER);

        GradientDrawable logoBg = new GradientDrawable();
        logoBg.setColor(blue);
        logoBg.setCornerRadius(100);
        logo.setBackground(logoBg);

        LinearLayout.LayoutParams logoParams =
                new LinearLayout.LayoutParams(75, 75);
        logoParams.gravity = Gravity.CENTER;
        main.addView(logo, logoParams);

        TextView title = new TextView(this);
        title.setText("JARR PROJECT");
        title.setTextColor(darkBlue);
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        title.setPadding(0, 15, 0, 3);
        main.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("DUMMY BUG SIMULATOR");
        subtitle.setTextColor(blue);
        subtitle.setTextSize(13);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 0, 0, 25);
        main.addView(subtitle);

        // Section
        TextView section = new TextView(this);
        section.setText("BUG TOOLS");
        section.setTextColor(darkBlue);
        section.setTextSize(19);
        section.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        section.setPadding(5, 5, 0, 12);
        section.setGravity(Gravity.CENTER_VERTICAL);
        main.addView(section);

        addCard(main, "🐛  Bug Simulator",
                "Simulasi bug dummy");

        addCard(main, "💥  Crash Simulator",
                "Simulasi crash dummy");

        addCard(main, "⚡  Lag Simulator",
                "Simulasi lag dummy");

        addCard(main, "📺  UI Glitch",
                "Efek glitch pada tampilan");

        addCard(main, "🌐  Network Error",
                "Simulasi error jaringan");

        addCard(main, "📜  Fake Log",
                "Tampilan log palsu");

        TextView footer = new TextView(this);
        TextView systemSection = new TextView(this);
        systemSection.setText("SYSTEM SIMULATION");
        systemSection.setTextColor(darkBlue);
        systemSection.setTextSize(19);
        systemSection.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        systemSection.setPadding(5, 28, 5, 8);

        main.addView(systemSection);

        String[] systemTools = {
                "📊  System Monitor",
                "🔋  Battery Simulator",
                "📡  Signal Simulator",
                "💾  Storage Simulator"
        };

        for (String tool : systemTools) {
            addCard(main, tool, "Dummy system simulation");
        }

        TextView version = new TextView(this);
        version.setText("Version 1.0 • Dummy Simulator");
        version.setTextColor(Color.GRAY);
        version.setTextSize(11);
        version.setGravity(Gravity.CENTER);
        version.setPadding(0, 10, 0, 5);
        main.addView(version);
        footer.setText("Jarr Project • Safe Dummy Simulator");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 25, 0, 0);
        main.addView(footer);

        scroll.addView(main);
        setContentView(scroll);
    }

    private void addCard(LinearLayout layout, String title, String desc) {

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(20, 18, 20, 18);

        GradientDrawable cardBg = new GradientDrawable();
        cardBg.setColor(Color.WHITE);
        cardBg.setCornerRadius(25);
        cardBg.setStroke(2, Color.rgb(220, 232, 245));
        card.setBackground(cardBg);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(darkBlue);
        titleView.setTextSize(18);
        titleView.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        TextView descView = new TextView(this);
        descView.setText(desc);
        descView.setTextColor(Color.GRAY);
        descView.setTextSize(12);
        descView.setPadding(0, 5, 0, 0);

        card.addView(titleView);
        card.addView(descView);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        85
                );

        params.setMargins(0, 8, 0, 8);
        layout.addView(card, params);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (title.contains("Bug Simulator")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            BugSimulatorActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("Crash Simulator")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            CrashSimulatorActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("Lag Simulator")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            LagSimulatorActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("UI Glitch")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            UIGlitchActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("Network Error")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            NetworkErrorActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("Fake Log")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            FakeLogActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("System Monitor")) {
                    Intent intent = new Intent(
                            MainActivity.this,
                            SystemMonitorActivity.class
                    );
                    startActivity(intent);
                } else if (title.contains("Battery Simulator")) {
                    startActivity(new Intent(MainActivity.this, BatterySimulatorActivity.class));
                } else if (title.contains("Signal Simulator")) {
                    startActivity(new Intent(MainActivity.this, SignalSimulatorActivity.class));
                } else if (title.contains("Storage Simulator")) {
                    startActivity(new Intent(MainActivity.this, StorageSimulatorActivity.class));
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "SIMULASI DUMMY: " + title,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}
