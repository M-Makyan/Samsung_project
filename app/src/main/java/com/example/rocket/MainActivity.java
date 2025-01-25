package com.example.rocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText exhaustVelocityInput, initialMassInput, finalMassInput, thrustInput, massFlowRateInput;
    private TextView deltaVOutput, specificImpulseOutput, thrustOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        exhaustVelocityInput = findViewById(R.id.exhaustVelocityInput);
        initialMassInput = findViewById(R.id.initialMassInput);
        finalMassInput = findViewById(R.id.finalMassInput);
        thrustInput = findViewById(R.id.thrustInput);
        massFlowRateInput = findViewById(R.id.massFlowRateInput);

        deltaVOutput = findViewById(R.id.deltaVOutput);
        specificImpulseOutput = findViewById(R.id.specificImpulseOutput);
        thrustOutput = findViewById(R.id.thrustOutput);

        Button calculateButton = findViewById(R.id.calculateButton);
        Button clearButton = findViewById(R.id.clearButton);

        // Set button listeners
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateParameters();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputs();
            }
        });
    }

    private void calculateParameters() {
        try {
            double exhaustVelocity = Double.parseDouble(exhaustVelocityInput.getText().toString());
            double initialMass = Double.parseDouble(initialMassInput.getText().toString());
            double finalMass = Double.parseDouble(finalMassInput.getText().toString());
            double thrust = Double.parseDouble(thrustInput.getText().toString());
            double massFlowRate = Double.parseDouble(massFlowRateInput.getText().toString());

            double deltaV = RocketCalculator.calculateDeltaV(exhaustVelocity, initialMass, finalMass);
            double specificImpulse = RocketCalculator.calculateSpecificImpulse(thrust, massFlowRate);
            double calculatedThrust = RocketCalculator.calculateThrust(exhaustVelocity, massFlowRate);

            deltaVOutput.setText(String.format("Delta-V: %.2f m/s", deltaV));
            specificImpulseOutput.setText(String.format("Specific Impulse: %.2f s", specificImpulse));
            thrustOutput.setText(String.format("Thrust: %.2f N", calculatedThrust));
        } catch (NumberFormatException e) {
            deltaVOutput.setText("Error: Invalid input");
            specificImpulseOutput.setText("");
            thrustOutput.setText("");
        }
    }

    private void clearInputs() {
        exhaustVelocityInput.setText("");
        initialMassInput.setText("");
        finalMassInput.setText("");
        thrustInput.setText("");
        massFlowRateInput.setText("");

        deltaVOutput.setText("");
        specificImpulseOutput.setText("");
        thrustOutput.setText("");
    }
}