package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class HomeActivity extends AppCompatActivity {

    TextInputEditText editTextElectricity, editTextGas;
    TextView click, result2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextElectricity = findViewById(R.id.electricity);
        editTextGas = findViewById(R.id.gas);
        click = findViewById(R.id.click1);
        result2 = findViewById(R.id.result1);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateResult();
            }
        });

    }

    private void calculateResult() {
        double electricity, gas, result;
        String electricity1, gas1;

        electricity1 = editTextElectricity.getText().toString();
        gas1 = editTextGas.getText().toString();

        if (electricity1.isEmpty() || gas1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            electricity = Double.parseDouble(electricity1);
            gas = Double.parseDouble(gas1);
            result = ((electricity * 12 * 0.85) + (gas * 12 * 2.983)) / 1000;

            // Display the result in the 'result2' TextView
            result2.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}
