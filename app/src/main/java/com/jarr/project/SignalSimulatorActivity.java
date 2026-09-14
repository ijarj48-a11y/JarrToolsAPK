package com.jarr.project;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignalSimulatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout main = new LinearLayout(this);
        main.setOrientation(LinearLayout.VERTICAL);
        main.setGravity(Gravity.CENTER);
        main.setPadding(25, 30, 25, 30);
        main.setBackgroundColor(Color.rgb(248, 251, 255));

        TextView title = new TextView(this);
        title.setText("📡 SIGNAL SIMULATOR");
        title.setTextColor(Color.rgb(13, 55, 100));
        title.setTextSize(27);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);

        TextView status = new TextView(this);
        status.setText(
                "DUMMY SIGNAL STATUS\n\n" +
                "Signal Strength : ████████░░ 80%\n" +
                "Network        : 4G\n" +
                "Connection     : STABLE\n\n" +
                "Semua data adalah simulasi."
        );
        status.setTextColor(Color.rgb(25, 118, 210));
        status.setTextSize(16);
        status.setGravity(Gravity.CENTER);
        status.setPadding(20, 30, 20, 30);

        main.addView(title);
        main.addView(status);

        TextView footer = new TextView(this);
        footer.setText("Jarr Project • Fake Data Only");
        footer.setTextColor(Color.GRAY);
        footer.setTextSize(12);
        footer.setGravity(Gravity.CENTER);

        main.addView(footer);

        setContentView(main);
    }
}
