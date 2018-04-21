package com.prashant.root.be;

import android.content.DialogInterface;
import android.content.Intent;
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
    private EditText uid;
    private EditText fullName;
    private EditText units;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_form);

        uid = findViewById(R.id.input_uid);
        fullName = findViewById(R.id.input_name);
        units = findViewById(R.id.input_units);
        button = findViewById(R.id.button_done_end);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    if (TextUtils.isEmpty(uid.getText())){
                        Toast.makeText(donation_form.this, "UId/Aadhar Number Can't be null!", Toast.LENGTH_SHORT).show();
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
                        startActivity(new Intent(donation_form.this,blood_banks.class));
                    }

                }


            }
        });



        Spinner spinner3 = (Spinner) findViewById(R.id.spinner_blood_group);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.blood_group, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);




/*

        public void onClickCheck(){

            String uid2 = uid.getText().toString();
            String name2 = fullName.getText().toString();
            String units2 = units.getText().toString();

            if (TextUtils.isEmpty(uid.getText()))

                if (uid2.equals("")){
                    Toast.makeText(this, "UId/Aadhar Number Can't be null!", Toast.LENGTH_SHORT).show();
                }

            if (name2.equals("")){
                Toast.makeText(this, "Invalid Name", Toast.LENGTH_SHORT).show();
            }

            if (units2.equals("")){
                Toast.makeText(this, "Invalid units of Blood Donation", Toast.LENGTH_SHORT).show();
            }


        }
        */

    }


}
