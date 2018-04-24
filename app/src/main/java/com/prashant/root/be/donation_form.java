package com.prashant.root.be;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class donation_form extends AppCompatActivity {

    private  Button button;
    private EditText fullName;
    private TextInputEditText uid_aadhar;
    private EditText units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);

        uid_aadhar = findViewById(R.id.input_uid);
        fullName = findViewById(R.id.input_name);
        units = findViewById(R.id.input_units);
        button = findViewById(R.id.button_done_end);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if (uid_aadhar.length()!=12 ){

                        Toast.makeText(donation_form.this, "UId/Aadhar Number invalid", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(fullName.getText())){
                        Toast.makeText(donation_form.this, "Invalid Name", Toast.LENGTH_SHORT).show();
                    }
                    else if (TextUtils.isEmpty(units.getText())){
                        Toast.makeText(donation_form.this, "Invalid units of Blood Donation", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(donation_form.this, "Recorded", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(donation_form.this,get_blood.class));
                    }

                }


            }
        });



        Spinner spinner3 =findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.gender, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);




    }

}
