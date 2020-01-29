package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> countries = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addButton).setOnClickListener(this);
        findViewById(R.id.deleteButton).setOnClickListener(this);

    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.editText);
        String text = editor.getText().toString();
        editor.setText(null);
        return text;
    }

    private void deleteCountry(String country)
    {
        for (int i = 0; i < countries.size(); i++) {
            String nimiTaulukosta = countries.get(i);
            if (nimiTaulukosta.equalsIgnoreCase(country))
            {
                countries.remove(i);
                break;
            }
        }
    }
    private void printAll()
    {
        ListView myListView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        myListView.setAdapter(aa);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.addButton)
        {
            String country =getTextFieldText();
            if(country != null && country.length() > 0)
            {
                countries.add(country);
            }
        }
        else if (v.getId() == R.id.deleteButton) {
            String country = getTextFieldText();
            deleteCountry(country);
        }
    printAll();
    }
}
