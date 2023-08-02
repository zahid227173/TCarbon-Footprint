package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class FoodActivity extends AppCompatActivity {

    TextInputEditText editTextCalorie;
    TextView click, result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        editTextCalorie = findViewById(R.id.calories);
        click = findViewById(R.id.click2);
        result1 = findViewById(R.id.result2);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        double calorie, result;
        String calorie1;

        calorie1 = editTextCalorie.getText().toString();

        if (calorie1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            calorie = Double.parseDouble(calorie1);

            result = (calorie * 1.852) / 1000;

            result1.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}