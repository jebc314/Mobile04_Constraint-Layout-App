package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nextButton;
    private Button[] toastButtons = new Button[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_4);

        nextButton = findViewById(R.id.button12);
        nextButton.setOnClickListener(this);

        toastButtons[0] = findViewById(R.id.button13);
        toastButtons[1] = findViewById(R.id.button14);
        toastButtons[2] = findViewById(R.id.button16);
        toastButtons[3] = findViewById(R.id.button15);

        for (Button b: toastButtons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "You clicked button " + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), FifthActivity.class);
        startActivity(intent);
    }
}