package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class UIGlitchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setGravity(Gravity.CENTER);
        main.setPadding(25, 30, 25, 30);
        main.setBackgroundColor(Color.rgb(248, 251, 255));

        TextView title = new TextView(this);
        title.setText("📺 UI GLITCH");
        title.setTextColor(Color.rgb(13, 55, 100));
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView effect = new TextView(this);
        effect.setText(
                "GLITCH PREVIEW\n\n" +
                "▓▒░  UI ERROR  ░▒▓\n" +
                "▌ DISPLAY GLITCH ▐\n\n" +
                "Efek ini hanya berada di dalam aplikasi."
        );
        effect.setTextColor(Color.rgb(25, 118, 210));
        effect.setTextSize(16);
        effect.setGravity(Gravity.CENTER);
        effect.setPadding(20, 30, 20, 30);

        main.addView(title);
        main.addView(effect);

        TextView footer = new TextView(this);
        footer.setText("Jarr Project • Safe Dummy Simulator");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 30, 0, 0);

        main.addView(footer);

        setContentView(main);
    }
}
