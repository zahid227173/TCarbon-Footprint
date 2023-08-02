package com.example.carbonfootprint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class AllActivity extends AppCompatActivity {

    TextInputEditText editTextElectricity, editTextGas, editTextCalorie;
    TextInputEditText editTextPetrol, editTextDiesel, editTextMiles;
    TextInputEditText editTextPharmacy, editTextCloth, editTextPapers, editTextIT, editTextDevices;
    TextInputEditText editTextFurniture, editTextHostels, editTextCellPhone, editTextRecreation;
    TextView click, result1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        editTextElectricity = findViewById(R.id.electricity);
        editTextGas = findViewById(R.id.gas);
        editTextCalorie = findViewById(R.id.calories);
        editTextPetrol = findViewById(R.id.petrol);
        editTextDiesel = findViewById(R.id.diesel);
        editTextMiles = findViewById(R.id.miles);
        editTextPharmacy = findViewById(R.id.pharmacy_cost);
        editTextCloth = findViewById(R.id.cloth_cost);
        editTextPapers = findViewById(R.id.paper_cost);
        editTextIT = findViewById(R.id.it_equipment_cost);
        editTextDevices = findViewById(R.id.devices_cost);
        editTextFurniture = findViewById(R.id.furniture_cost);
        editTextHostels = findViewById(R.id.hotels_cost);
        editTextCellPhone = findViewById(R.id.cell_phone_cost);
        editTextRecreation = findViewById(R.id.recreation_cost);
        click = findViewById(R.id.click6);
        result1 = findViewById(R.id.result6);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResult();
            }
        });
    }


    private void calculateResult() {
        double electricity, gas, calorie, petrol, diesel, miles;
        double pharmacy, cloth, papers, it, devices, furniture, hostels, cellphone, recreation, ans1, ans2, result;
        String electricity1, gas1, calorie1, petrol1, diesel1, miles1;
        String pharmacy1, cloth1, papers1, it1, devices1, furniture1, hostels1, cellphone1, recreation1;

        electricity1 = editTextElectricity.getText().toString();
        gas1 = editTextGas.getText().toString();
        calorie1 = editTextCalorie.getText().toString();
        petrol1 = editTextPetrol.getText().toString();
        diesel1 = editTextDiesel.getText().toString();
        miles1 = editTextMiles.getText().toString();
        pharmacy1 = editTextPharmacy.getText().toString();
        cloth1 = editTextCloth.getText().toString();
        papers1 = editTextPapers.getText().toString();
        it1 = editTextIT.getText().toString();
        devices1 = editTextDevices.getText().toString();
        furniture1 = editTextFurniture.getText().toString();
        hostels1 = editTextHostels.getText().toString();
        cellphone1 = editTextCellPhone.getText().toString();
        recreation1 = editTextRecreation.getText().toString();


        if (electricity1.isEmpty() || gas1.isEmpty() || calorie1.isEmpty() || petrol1.isEmpty() || diesel1.isEmpty() || miles1.isEmpty() || pharmacy1.isEmpty() || cloth1.isEmpty() || papers1.isEmpty() || it1.isEmpty() || devices1.isEmpty()  || furniture1.isEmpty() || hostels1.isEmpty() || cellphone1.isEmpty() || recreation1.isEmpty()) {
            // Handle the case where the user hasn't entered values in both fields
            // For example, show an error message or set a default value for the result.
            return;
        }

        try {
            electricity = Double.parseDouble(electricity1);
            gas = Double.parseDouble(gas1);
            calorie = Double.parseDouble(calorie1);
            petrol = Double.parseDouble(petrol1);
            diesel = Double.parseDouble(diesel1);
            miles = Double.parseDouble(miles1);
            pharmacy = Double.parseDouble(pharmacy1);
            cloth = Double.parseDouble(cloth1);
            papers = Double.parseDouble(papers1);
            it = Double.parseDouble(it1);
            devices = Double.parseDouble(devices1);
            furniture = Double.parseDouble(furniture1);
            hostels = Double.parseDouble(hostels1);
            cellphone = Double.parseDouble(cellphone1);
            recreation = Double.parseDouble(recreation1);


            ans1 = ((electricity * 12 * 0.85) + (gas * 12 * 2.983) + (calorie * 1.852) + (petrol * 2.296) + (diesel * 2.653) + (miles * 0.304)) / 1000;
            ans2 = ((pharmacy * 0.0074) + (cloth * 0.0049) + (papers * 0.0097) + (it * 0.0095) + (devices * 0.0057) + (furniture * 0.0074) + (hostels * 0.0075) + (cellphone * 0.0090) + (recreation * 0.0042))/1000;
            result = ans1 + ans2;
            // Display the result in the 'result2' TextView
            result1.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            // Handle the case where the user has entered invalid values
            // For example, show an error message or set a default value for the result.
            e.printStackTrace();
        }
    }
}