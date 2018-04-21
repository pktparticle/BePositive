package com.prashant.root.be;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private Button mTextMessage;
    private ImageView imageView;

    BottomNavigationView navigation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         navigation = (BottomNavigationView) findViewById(R.id.navigation);

        mTextMessage =  findViewById(R.id.message);
        imageView =  findViewById(R.id.home_image);



        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_get_blood:
                    mTextMessage.setText(R.string.title_get_blood);
                    Glide.with(getApplicationContext()).load(R.drawable.home_get_blood).into(imageView);
                    mTextMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            open();
                        }
                    });
                    return true;
                case R.id.navigation_donate_blood:
                    mTextMessage.setText(R.string.title_donate_blood);
                    Glide.with(getApplicationContext()).load(R.drawable.home_donate_blood).into(imageView);

                    mTextMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this, DonateBlood.class));
                        }
                    });
                    return true;
                case R.id.navigation_first_aid:
                    mTextMessage.setText(R.string.title_first_aid);
                    Glide.with(getApplicationContext()).load(R.drawable.home_first_aid2).into(imageView);
                    mTextMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(MainActivity.this, FirstAid.class));
                        }
                    });
                    return true;
            }
            return false;
        }
    };


/*

    public void menuTest (MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.navigation_get_blood:

                mTextMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        open();
                    }
                });

                break;



        }
    }

*/

    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.dialog_get_blood);
        alertDialogBuilder.setTitle("We pray for your Good Health");
                alertDialogBuilder.setPositiveButton("Sure",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Intent intent = new Intent(MainActivity.this,get_blood.class);
                                startActivity(intent);
                                Toast.makeText(MainActivity.this,"We appreciate your contribution!",Toast.LENGTH_LONG).show();

                            }
                        });

        alertDialogBuilder.setNegativeButton("Back",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
