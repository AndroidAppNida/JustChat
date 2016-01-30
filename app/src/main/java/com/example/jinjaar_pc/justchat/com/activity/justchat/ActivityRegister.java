package com.example.jinjaar_pc.justchat.com.activity.justchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinjaar_pc.justchat.R;
import com.example.jinjaar_pc.justchat.com.database.justchat.User;


public class ActivityRegister extends Activity {
    private EditText inputUsername;
    private EditText inputPassword;
    private Button registerButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerButton = (Button)findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputPassword = (EditText)findViewById(R.id.registerPassword);
                inputUsername = (EditText)findViewById(R.id.registerUsername);

                String username = inputUsername.getText().toString();
                String password = inputPassword.getText().toString();

                user = new User(username,password);
                user.save();

                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);

                startActivity(intent);

            }
        });
    }

}
