package com.example.webchatdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ChatClientInterface {
    ChatClient chatClient = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sendMessageBtn).setOnClickListener(this);
        findViewById(R.id.closeConnectionButton).setOnClickListener(this);
        openConnection();
    }


    @Override
    public void onClick(View v) {


        if (v.getId() == R.id.sendMessageBtn) {
            sendMessage();
        }
        if (v.getId() == R.id.closeConnectionButton) {
            closeConnection();
        }
    }


    private void closeConnection() {
        if (chatClient != null && chatClient.isOpen()) {
            chatClient.close();
        }
    }

    private void sendMessage() {
        if (chatClient != null && chatClient.isOpen()) {
            EditText editor = findViewById(R.id.messageEditText);
            String text = editor.getText().toString();
            chatClient.send(text);
        }
    }

    private void openConnection() {
        try {
            chatClient = new ChatClient(new URI("ws://192.168.1.35:1337"),this);
            chatClient.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView messageView = findViewById(R.id.messageView);

                    messageView.append(message + "\n");




            }
        });
    }
}
