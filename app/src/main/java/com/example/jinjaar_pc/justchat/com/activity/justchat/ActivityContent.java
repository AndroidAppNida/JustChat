package com.example.jinjaar_pc.justchat.com.activity.justchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jinjaar_pc.justchat.R;
import com.example.jinjaar_pc.justchat.com.database.justchat.User;

import java.util.ArrayList;


public class ActivityContent extends Activity {

    private Button sendMessage;
    private ListView chatArea;
    private ArrayList<String> chatMessages;
    private ArrayAdapter<String> adapter;
    private EditText inputMessage;
    private User currentUser;
    private TextView usernameDisplay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        sendMessage = (Button) findViewById(R.id.sendMessage);
        chatArea = (ListView) findViewById(R.id.chatArea);
        inputMessage = (EditText) findViewById(R.id.message);

        chatMessages = new ArrayList<String>();
        Intent intent = getIntent();
         currentUser = (User) intent.getSerializableExtra("currentUser");
        usernameDisplay = (TextView)findViewById(R.id.currentUser);
        usernameDisplay.setText(currentUser.getUsername());

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, chatMessages);
        chatArea.setAdapter(adapter);

        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chatMessages.add(inputMessage.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
