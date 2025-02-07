package com.example.rocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btnGoToMain = findViewById(R.id.btnGoToMain);
        Button btnGoToWingLoading = findViewById(R.id.btnGoToWingLoading);

        btnGoToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnGoToWingLoading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, WingLoading.class);
                startActivity(intent);
            }
        });
    }
}
