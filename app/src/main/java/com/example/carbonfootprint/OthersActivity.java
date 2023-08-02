package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class OthersActivity extends AppCompatActivity {

    TextInputEditText editTextPharmacy, editTextCloth, editTextPapers, editTextIT, editTextDevices;
    TextInputEditText editTextFurniture, editTextHostels, editTextCellPhone, editTextRecreation;
    TextView click, result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        editTextPharmacy = findViewById(R.id.pharmacy_cost);
        editTextCloth = findViewById(R.id.cloth_cost);
        editTextPapers = findViewById(R.id.paper_cost);
        editTextIT = findViewById(R.id.it_equipment_cost);
        editTextDevices = findViewById(R.id.devices_cost);
        editTextFurniture = findViewById(R.id.furniture_cost);
        editTextHostels = findViewById(R.id.hotels_cost);
        editTextCellPhone = findViewById(R.id.cell_phone_cost);
        editTextRecreation = findViewById(R.id.recreation_cost);
        click = findViewById(R.id.click5);
        result1 = findViewById(R.id.result5);


        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        double pharmacy, cloth, papers, it, devices, furniture, hostels, cellphone, recreation, result;
        String pharmacy1, cloth1, papers1, it1, devices1, furniture1, hostels1, cellphone1, recreation1;

        pharmacy1 = editTextPharmacy.getText().toString();
        cloth1 = editTextCloth.getText().toString();
        papers1 = editTextPapers.getText().toString();
        it1 = editTextIT.getText().toString();
        devices1 = editTextDevices.getText().toString();
        furniture1 = editTextFurniture.getText().toString();
        hostels1 = editTextHostels.getText().toString();
        cellphone1 = editTextCellPhone.getText().toString();
        recreation1 = editTextRecreation.getText().toString();

        if (pharmacy1.isEmpty() || cloth1.isEmpty() || papers1.isEmpty() || it1.isEmpty() || devices1.isEmpty()  || furniture1.isEmpty() || hostels1.isEmpty() || cellphone1.isEmpty() || recreation1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            pharmacy = Double.parseDouble(pharmacy1);
            cloth = Double.parseDouble(cloth1);
            papers = Double.parseDouble(papers1);
            it = Double.parseDouble(it1);
            devices = Double.parseDouble(devices1);
            furniture = Double.parseDouble(furniture1);
            hostels = Double.parseDouble(hostels1);
            cellphone = Double.parseDouble(cellphone1);
            recreation = Double.parseDouble(recreation1);


            result = ((pharmacy * 0.0074) + (cloth * 0.0049) + (papers * 0.0097) + (it * 0.0095) + (devices * 0.0057) + (furniture * 0.0074) + (hostels * 0.0075) + (cellphone * 0.0090) + (recreation * 0.0042))/1000;

            result1.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}