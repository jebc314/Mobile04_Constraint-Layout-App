package com.cuijeb.constraintlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class SeventhActivity extends AppCompatActivity implements View.OnClickListener {

    private Button nextButton;
    private CheckBox[] checks = new CheckBox[17];
    private int total = 0;
    private TextView counterTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_7);

        nextButton = findViewById(R.id.button26);
        nextButton.setOnClickListener(this);

        counterTextView = findViewById(R.id.textView);
        for (int i = 0; i < 17; i++) {
            String id = "checkBox"+ i;
            int resID = getResources().getIdentifier(id, "id", getPackageName());
            checks[i] = findViewById(resID);
            checks[i].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                        total++;
                    else total--;
                    counterTextView.setText("" + total);
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}