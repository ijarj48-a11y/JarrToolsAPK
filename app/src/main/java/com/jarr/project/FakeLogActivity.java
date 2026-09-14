package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FakeLogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setPadding(20, 25, 20, 20);
        main.setBackgroundColor(Color.rgb(248, 251, 255));

        TextView title = new TextView(this);
        title.setText("📜  FAKE LOG");
        title.setTextColor(Color.rgb(13, 55, 100));
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView log = new TextView(this);
        log.setText(
                "[JARR] Starting simulation...\n" +
                "[INFO] Dummy module loaded\n" +
                "[WARN] Fake warning detected\n" +
                "[ERROR] Simulated error\n" +
                "[INFO] No system changes made\n" +
                "[JARR] Simulation complete"
        );
        log.setTextColor(Color.rgb(25, 118, 210));
        log.setTextSize(14);
        log.setPadding(20, 25, 20, 25);

        main.addView(title);
        main.addView(log);

        TextView footer = new TextView(this);
        footer.setText("Jarr Project • Fake Data Only");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);
        footer.setPadding(0, 25, 0, 0);

        main.addView(footer);

        setContentView(main);
    }
}
