package com.prashant.root.be;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DiseaseDetail extends AppCompatActivity {

    TextView diseasetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease_detail);

        diseasetext = findViewById(R.id.disease_text);

        Intent i = getIntent();
        String diseaseText = i.getStringExtra("disease_text");
        String diseaseName = i.getStringExtra("disease_name");
        diseasetext.setText(diseaseText);


    }
}