package com.hst.security;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(30, 40, 30, 30);
        layout.setBackgroundColor(Color.rgb(16,27,36));

        TextView title = new TextView(this);
        title.setText("🛡️ HST MOBILE SECURITY");
        title.setTextSize(24);
        title.setTextColor(Color.GREEN);
        title.setGravity(Gravity.CENTER);

        layout.addView(title);

        addButton(layout, "Face / Fingerprint Admin", "Android biometric setup");
        addButton(layout, "Wi-Fi Protection", "Manage trusted Wi-Fi");
        addButton(layout, "Bluetooth Protection", "Manage trusted devices");
        addButton(layout, "Wrong Access Alarm", "Alarm test successful");

        setContentView(layout);
    }

    private void addButton(LinearLayout layout, String name, String message) {
        Button button = new Button(this);
        button.setText(name);
        button.setOnClickListener(v ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        );
        layout.addView(button);
    }
}
