package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nextButton;
    private Button colorButton;
    private Button increaseButton;
    private Button decreaseButton;

    private int percent = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_1);

        nextButton = findViewById(R.id.button);
        nextButton.setOnClickListener(this);

        colorButton = findViewById(R.id.button2);
        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double c = percent / 100.0;
                double red = 0, green = 0, blue = 0;
                if(c >= 0 && c <= (1/6.f)){
                    red = 255;
                    green = 1530 * c;
                    blue = 0;
                } else if( c > (1/6.f) && c <= (1/3.f) ){
                    red = 255 - (1530 * (c - 1/6f));
                    green = 255;
                    blue = 0;
                } else if( c > (1/3.f) && c <= (1/2.f)){
                    red = 0;
                    green = 255;
                    blue = 1530 * (c - 1/3f);
                } else if(c > (1/2f) && c <= (2/3f)) {
                    red = 0;
                    green = 255 - ((c - 0.5f) * 1530);
                    blue = 255;
                } else if( c > (2/3f) && c <= (5/6f) ){
                    red = (c - (2/3f)) * 1530;
                    green = 0;
                    blue = 255;
                } else if(c > (5/6f) && c <= 1 ){
                    red = 255;
                    green = 0;
                    blue = 255 - ((c - (5/6f)) * 1530);
                }
                colorButton.setBackgroundColor(Color.rgb((int)red, (int)green, (int)blue));
                percent++;
                if (percent > 100)
                    percent = 0;
            }
        });

        increaseButton = findViewById(R.id.button3);
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSize(1);
            }
        });

        decreaseButton = findViewById(R.id.button4);
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeSize(-1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);
    }

    public void changeSize(int sign) {
        int width = (int)(nextButton.getLayoutParams().width + 10 * sign);
        int height = (int)(nextButton.getLayoutParams().height + 10 * sign);
        nextButton.setLayoutParams(new ConstraintLayout.LayoutParams(width, height));
        // Log.d("BUTTON CLICK", "" + width + " " + height);
    }
}