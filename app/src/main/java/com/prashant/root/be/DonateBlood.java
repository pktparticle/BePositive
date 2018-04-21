package com.prashant.root.be;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DonateBlood extends AppCompatActivity {

    ListView mListView;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);


        mListView = findViewById(R.id.list_view);
        textView = findViewById(R.id.listHead);
        textView.setTextSize(18);
        textView.setText(R.string.guideline_head);
        button = findViewById(R.id.agreement_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DonateBlood.this,donation_form.class));
            }
        });

        // storing string resources into Array
        String[] first_aid_diseses = getResources().getStringArray(R.array.donors_guidelines);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_donate_blood, R.id.listGuidelines, first_aid_diseses);

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
                        diseaseText = getResources().getString(R.string.eligibilities);
                        break;
                    case 1:
                        diseaseText = getResources().getString(R.string.nonEligibilities);
                        break;
                    case 2:
                        diseaseText = getResources().getString(R.string.preparation);
                        break;
                    case 3:
                        diseaseText = getResources().getString(R.string.postDonationCare);
                        break;
                    case 4:
                        diseaseText = getResources().getString(R.string.howToRelieve);
                        break;



                    default:
                        break;

                }

                // Launching new Activity on selecting single List Item
                Intent intent = new Intent(DonateBlood.this,DiseaseDetail.class);
                // sending data to new activity
                intent.putExtra("disease_text", diseaseText);

                intent.putExtra("disease_name", diseaseName);
                startActivity(intent);

            }  });
    }
}
