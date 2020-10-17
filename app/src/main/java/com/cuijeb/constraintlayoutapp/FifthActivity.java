package com.cuijeb.constraintlayoutapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class FifthActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nextButton;
    private ScrollView scroll;
    private int percent = 0;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_5);

        nextButton = findViewById(R.id.button17);
        nextButton.setOnClickListener(this);

        scroll = findViewById(R.id.filler_scrollview);
        scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // Log.v("SCROLL CHANGE", ""+(scrollY - oldScrollY));
                percent += (scrollY - oldScrollY) / 10;
                if (percent < 0) {
                    percent %= 100;
                    percent += 100;
                } else {
                    percent %= 100;
                }
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
                v.setBackgroundColor(Color.rgb((int)red, (int)green, (int)blue));
            }
        });
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SixthActivity.class);
        startActivity(intent);
    }
}