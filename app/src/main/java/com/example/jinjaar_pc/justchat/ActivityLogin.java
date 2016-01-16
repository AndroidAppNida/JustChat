package com.example.jinjaar_pc.justchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ActivityLogin extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = (Button) findViewById(R.id.login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = (EditText) findViewById(R.id.inputField);
                String userNameText = username.getText().toString();
                Intent intent = new Intent(ActivityLogin.this,ActivityContent.class);
                intent.putExtra("username",userNameText );
                startActivity(intent);
            }
        });

    }

}
