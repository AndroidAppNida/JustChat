package com.example.jinjaar_pc.justchat.com.activity.justchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jinjaar_pc.justchat.R;
import com.example.jinjaar_pc.justchat.com.database.justchat.User;

import java.io.Serializable;


public class ActivityLogin extends Activity {

    private EditText inputPassword;
    private EditText inputUsername;
    private String usernameText;
    private String passwordText;
    private Button registerButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginBtn = (Button) findViewById(R.id.login);

        registerButton = (Button) findViewById(R.id.register);
        inputPassword = (EditText)findViewById(R.id.password);
        inputUsername = (EditText) findViewById(R.id.username);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usernameText = inputUsername.getText().toString();
                passwordText = inputPassword.getText().toString();
                User user = User.findWithQuery(User.class,"Select username,password,id from user " +
                        "where username = ? and password = ?",usernameText,passwordText).get(0);

                Intent intent = new Intent(ActivityLogin.this, ActivityContent.class);
                if (user != null){
                    intent.putExtra("currentUser",  user);
                }
                startActivity(intent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });

    }

}
