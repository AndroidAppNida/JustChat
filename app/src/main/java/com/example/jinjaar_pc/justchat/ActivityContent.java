package com.example.jinjaar_pc.justchat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class ActivityContent extends Activity {

    Button messageButton;
    ListView chatArea;
    ArrayList<String> str;
    ArrayAdapter<String> adapter;
    EditText et;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        messageButton = (Button) findViewById(R.id.sendMessage);
        chatArea = (ListView) findViewById(R.id.chatArea);
        et = (EditText) findViewById(R.id.message);

        str = new ArrayList<String>();

        for(int i = 0; i < 2; i++) {
            str.add("Row: " + i);
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, str);
        chatArea.setAdapter(adapter);

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
