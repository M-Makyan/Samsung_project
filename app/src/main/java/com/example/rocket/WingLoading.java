package com.example.rocket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WingLoading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wing_loading);

        EditText inputMass = findViewById(R.id.input_mass);
        EditText inputWingArea = findViewById(R.id.input_wing_area);
        Button btnCalculate = findViewById(R.id.btn_calculate);
        TextView outputResult = findViewById(R.id.output_result);

        Button backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView imageView = findViewById(R.id.imageView);
                try {
                    double massKg = Double.parseDouble(inputMass.getText().toString());
                    double wingAreaM2 = Double.parseDouble(inputWingArea.getText().toString());

                    if (massKg <= 0 || wingAreaM2 <= 0) {
                        outputResult.setText("Mass and Wing Area must be greater than zero.");
                        return;
                    }

                    double weightOunce = massKg * 35.274;
                    double wingAreaSqIn = wingAreaM2 * 1550;
                    double wingAreaSqFt = wingAreaSqIn / 144;

                    double wingCubicLoading = weightOunce / Math.pow(wingAreaSqFt, 1.5);

                    outputResult.setText("Wing Cubic Loading: " + String.format("%.2f", wingCubicLoading));
                } catch (NumberFormatException e) {
                    outputResult.setText("Please enter valid numbers.");
                }

            }
        });
    }
}
