package com.example.lab_2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mapButton).setOnClickListener(this);
        findViewById(R.id.callButton).setOnClickListener(this);
        findViewById(R.id.goButton).setOnClickListener(this);
    }

    private String getTextFieldText() {
        EditText editor = findViewById(R.id.textEditor);
        String text = editor.getText().toString();

        return text;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.mapButton){
            Uri location = Uri.parse("geo:65.059252, 25.466248?z=15");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if(isIntentSafe){
                startActivity(mapIntent);
            }
        }

        else if(view.getId()== R.id.callButton) {
            Uri number = Uri.parse("tel:+358 20 6110200");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(callIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if(isIntentSafe){
                startActivity(callIntent);
            }
        }

        else if(view.getId()== R.id.goButton) {
            String web = getTextFieldText();
            Uri webpage = Uri.parse(web);
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if(isIntentSafe){
                startActivity(webIntent);
            }
        }

    }
}
