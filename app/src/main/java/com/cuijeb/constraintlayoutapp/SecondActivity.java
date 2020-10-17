package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nextButton;
    private Button increaseButton;
    private Button decreaseButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2);

        nextButton = findViewById(R.id.button5);
        nextButton.setOnClickListener(this);

        decreaseButton = findViewById(R.id.button6);
        increaseButton = findViewById(R.id.button7);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, nextButton.getTextSize()/getResources().getDisplayMetrics().scaledDensity - 1);
            }
        });
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,nextButton.getTextSize()/getResources().getDisplayMetrics().scaledDensity + 1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
        startActivity(intent);
    }
}