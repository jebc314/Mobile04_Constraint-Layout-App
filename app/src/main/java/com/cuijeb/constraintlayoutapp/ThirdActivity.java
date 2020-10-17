package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nextButton;
    private Button fruitButton;
    private TextView message;
    private Button randomButton;

    private String[] fruits;
    private int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_3);

        nextButton = findViewById(R.id.button8);
        nextButton.setOnClickListener(this);

        fruits = getResources().getStringArray(R.array.messages);
        fruitButton = findViewById(R.id.button9);
        message = findViewById(R.id.hello_textView);
        fruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText(fruits[pos]);
                pos++;
                pos%=fruits.length;
            }
        });

        randomButton = findViewById(R.id.button10);
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setBackgroundColor(Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), FourthActivity.class);
        startActivity(intent);
    }
}