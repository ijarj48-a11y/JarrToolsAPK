package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BugSimulatorActivity extends Activity {

    int blue = Color.rgb(25, 118, 210);
    int darkBlue = Color.rgb(13, 55, 100);
    int bg = Color.rgb(245, 249, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(20, 25, 20, 20);
        main.setBackgroundColor(bg);

        TextView title = new TextView(this);
        title.setText("🐛  BUG SIMULATOR");
        title.setTextColor(darkBlue);
        title.setTextSize(24);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        main.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Safe Dummy Simulation");
        subtitle.setTextColor(blue);
        subtitle.setTextSize(13);
        subtitle.setGravity(Gravity.CENTER);
        subtitle.setPadding(0, 5, 0, 25);
        main.addView(subtitle);

        String[] bugs = {
                "⚠️  Null Pointer",
                "🔄  Infinite Loading",
                "📦  UI Overflow",
                "🌐  Connection Error",
                "📱  Fake App Freeze",
                "📜  Fake Error Log"
        };

        for (String bug : bugs) {
            TextView card = new TextView(this);
            card.setText(bug);
            card.setTextColor(darkBlue);
            card.setTextSize(16);
            card.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            card.setGravity(Gravity.CENTER_VERTICAL);
            card.setPadding(20, 0, 20, 0);

            GradientDrawable shape = new GradientDrawable();
            shape.setColor(Color.WHITE);
            shape.setCornerRadius(22);
            shape.setStroke(2, Color.rgb(215, 228, 242));
            card.setBackground(shape);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            65
                    );

            params.setMargins(0, 0, 0, 12);
            main.addView(card, params);

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    card.setText("⏳  SIMULATING...");
                    card.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            card.setText(bug + "\n✓ Dummy simulation complete");
                        }
                    }, 900);
                }
            });
        }

        TextView footer = new TextView(this);
        footer.setText("Jarr Project • 100% Safe Dummy");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 15, 0, 0);

        main.addView(footer);

        setContentView(main);
    }
}
