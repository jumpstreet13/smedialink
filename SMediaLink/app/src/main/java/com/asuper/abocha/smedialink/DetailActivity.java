package com.asuper.abocha.smedialink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView textView;
    private ButtonWithProgress button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView) findViewById(R.id.textViewDetailActivity);
        button = (ButtonWithProgress) findViewById(R.id.buttonDetailActivity);
        Element element = HomeForElements.get(getApplicationContext()).getElement(getIntent().getIntExtra(MainActivity.NUMBER, 0));
        textView.setText(String.valueOf(element.getNumber()));
        button.setRatio(element.getGreen());
    }
}
