package com.prashant.root.be;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class blood_banks extends AppCompatActivity {
    private ImageView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_banks);

        location =findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/26.2496953,78.1698474/dd+mall+location+maps/@26.232404,78.1441663,13z/data=!3m2!4b1!5s0x3976c42842f59eaf:0xd6a1f03027683535!4m9!4m8!1m1!4e1!1m5!1m1!1s0x3976c42868348417:0xed839ed3252040!2m2!1d78.1663396!2d26.2093128")));
            }
        });

    }
}
