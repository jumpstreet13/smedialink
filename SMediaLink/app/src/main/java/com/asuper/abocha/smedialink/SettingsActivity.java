package com.asuper.abocha.smedialink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private EditText number;
    private EditText k;
    private Button okButton;
    private boolean isNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        number = (EditText) findViewById(R.id.editTextnumberSettingsActivity);
        k = (EditText) findViewById(R.id.editTextkSettingActivity);
        okButton = (Button) findViewById(R.id.buttonSettingsActivity);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Element element = findThisElement(Integer.parseInt(number.getText().toString()));
                element.setGreen(Float.parseFloat(k.getText().toString()));
                if(isNew){
                    Toast.makeText(SettingsActivity.this, "Добавлена новая запись", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SettingsActivity.this, "Запись обновлена", Toast.LENGTH_SHORT).show();
                }
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
