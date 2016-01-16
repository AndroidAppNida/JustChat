package com.example.jinjaar_pc.justchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ActivityContent extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        Intent intent = getIntent();
        String message = intent.getStringExtra("username");
        ((TextView)findViewById(R.id.myAwesomeTextView)).setText(message);
    }
}
