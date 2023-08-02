package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class VehicleActivity extends AppCompatActivity {

    TextInputEditText editTextPetrol, editTextDiesel;
    TextView click, result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        editTextPetrol = findViewById(R.id.petrol);
        editTextDiesel = findViewById(R.id.diesel);
        click = findViewById(R.id.click3);
        result1 = findViewById(R.id.result3);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });

    }

    private void calculateResult() {
        double petrol, diesel, result;
        String petrol1, diesel1;

        petrol1 = editTextPetrol.getText().toString();
        diesel1 = editTextDiesel.getText().toString();

        if (petrol1.isEmpty() || diesel1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            petrol = Double.parseDouble(petrol1);
            diesel = Double.parseDouble(diesel1);
            result = ((petrol * 2.296) + (diesel * 2.653))/1000;

            result1.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}