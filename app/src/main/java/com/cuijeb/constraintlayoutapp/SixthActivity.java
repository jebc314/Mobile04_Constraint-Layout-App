package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixthActivity extends AppCompatActivity implements View.OnClickListener{

    private Button nextButton;
    private Button[] increaseButtons = new Button[8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_6);

        nextButton = findViewById(R.id.button18);
        nextButton.setOnClickListener(this);

        for(int i=1 ; i<8 ; i++)
        {
            String id = "button"+ (i + 18);
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            increaseButtons[i] = findViewById(resID);
            increaseButtons[i].setText("0");
            increaseButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button)v;
                    int currentInt = Integer.parseInt(button.getText().toString());
                    currentInt++;
                    button.setText(""+currentInt);
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SeventhActivity.class);
        startActivity(intent);
    }
}