package com.prashant.root.be;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatCallback;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Locale;

public class FirstAid extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        mListView = findViewById(R.id.list_view);

        // storing string resources into Array
        String[] first_aid_diseses = getResources().getStringArray(R.array.first_aid_diseases);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.text, first_aid_diseses);

        // Binding Array to ListAdapter
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String diseaseText = " ";
                String diseaseName = (String) mListView.getItemAtPosition(position);
                switch (position){
                    case 0:
                        diseaseText = getResources().getString(R.string.BURNS_AND_SCALDS);
                        break;
                    case 1:
                        diseaseText = getResources().getString(R.string.BITES_AND_STINGS);
                        break;
                    case 2:
                        diseaseText = getResources().getString(R.string.DROWNING);
                        break;
                    case 3:
                        diseaseText = getResources().getString(R.string.ELECTRICAL_BURN);
                        break;
                    case 4:
                        diseaseText = getResources().getString(R.string.FAINTING);
                        break;
                    case 5:
                        diseaseText = getResources().getString(R.string.FEVER);
                        break;
                    case 6:
                        diseaseText = getResources().getString(R.string.FRACTURES_CLOSED);
                        break;
                    case 7:
                        diseaseText = getResources().getString(R.string.FRACTURES_OPEN);
                        break;
                    case 8:
                        diseaseText = getResources().getString(R.string.FOREIGN_OBJECT_IN_THE_EYE);
                        break;
                    case 9:
                        diseaseText = getResources().getString(R.string.HEART_ATTACK);
                        break;
                    case 10:
                        diseaseText = getResources().getString(R.string.NOSEBLEED);
                        break;
                    case 11:
                        diseaseText = getResources().getString(R.string.SEIZURES);
                        break;
                    case 12:
                        diseaseText = getResources().getString(R.string.SEVERE_EXTERNAL_BLEEDING);
                        break;
                    case 13:
                        diseaseText = getResources().getString(R.string.SWALLOWED_POISONS);
                        break;
                    case 14:
                        diseaseText = getResources().getString(R.string.VOMITING_AND_DIARRHEA);
                        break;
                    default:
                        break;

                }

                // Launching new Activity on selecting single List Item
                Intent intent = new Intent(FirstAid.this,DiseaseDetail.class);
                // sending data to new activity
                intent.putExtra("disease_text", diseaseText);

                intent.putExtra("disease_name", diseaseName);
                startActivity(intent);

            }
        });


    }


}