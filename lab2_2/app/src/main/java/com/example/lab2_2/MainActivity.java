package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.englishButton).setOnClickListener(this);
        findViewById(R.id.svenskaButton).setOnClickListener(this);
        findViewById(R.id.suomiButton).setOnClickListener(this);
        findViewById(R.id.surpriseButton).setOnClickListener(this);
    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.nameEditor);
        String text = editor.getText().toString();

        return text;
    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.englishButton)
        {
            String nimi = getTextFieldText();
            if (nimi != null && nimi.length() > 0)
            {
                TextView nimiView =findViewById(R.id.textView);
                nimiView.setText("Hello  " + nimi +"\n");

            }
        }
        else if (v.getId()== R.id.svenskaButton)
        {
            String nimi = getTextFieldText();
            if (nimi != null && nimi.length() > 0)
            {
                TextView nimiView =findViewById(R.id.textView);
                nimiView.setText("Hejjsan  " + nimi +"\n");

            }
        }
        else if (v.getId()== R.id.suomiButton)
        {
            String nimi = getTextFieldText();
            if (nimi != null && nimi.length() > 0)
            {
                TextView nimiView =findViewById(R.id.textView);
                nimiView.setText("Hyvää päivää  " + nimi +"\n");

            }
        }
        else if (v.getId()== R.id.surpriseButton)
        {
            String nimi = getTextFieldText();
            if (nimi != null && nimi.length() > 0)
            {
                TextView nimiView =findViewById(R.id.textView);
                nimiView.setText("Hola Hola  " + nimi +"\n");

            }
        }
    }
}
