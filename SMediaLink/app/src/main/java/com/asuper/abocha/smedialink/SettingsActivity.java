package com.asuper.abocha.smedialink;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    public static final String APP_PREFERENCES = "mysettings";
    public static final String NUMBER = "number";
    public static final String KOFF = "koff";
    private EditText number;
    private EditText koff;
    private Button okButton, backButton;
    private boolean isNew;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        number = (EditText) findViewById(R.id.editTextnumberSettingsActivity);
        koff = (EditText) findViewById(R.id.editTextkSettingActivity);
        okButton = (Button) findViewById(R.id.buttonSettingsActivity);
        backButton = (Button) findViewById(R.id.buttonBackSetitngsActivity);
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(NUMBER)){
            number.setText(String.valueOf(sharedPreferences.getInt(NUMBER, 0)));
            koff.setText(String.valueOf(sharedPreferences.getFloat(KOFF, 0.0f)));
        }


        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Element element = findThisElement(Integer.parseInt(number.getText().toString()));
                element.setGreen(Float.parseFloat(koff.getText().toString()));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putInt(NUMBER, element.getNumber());
                edit.putFloat(KOFF, element.getGreen());
                edit.apply();
                if(isNew){
                    Toast.makeText(SettingsActivity.this, R.string.recordAdded, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SettingsActivity.this, R.string.recordRefreshed, Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SettingsActivity.super.onBackPressed();
            }
        });
    }

    private Element findThisElement(int number) {
        List<Element> elements = HomeForElements.get(getApplicationContext()).getElements();
        for (Element element : elements) {
            if (element.getNumber() == number) {
                isNew = false;
                return element;
            }
        }
        Element element = new Element(elements.size(), 0);
        elements.add(element);
        isNew = true;
        return element;
    }
}
