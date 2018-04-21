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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button mTextMessage;
    private ImageView imageView;
    BottomNavigationView navigation;



    public static final int RC_SIGN_IN = 1;
    public static final String ANONYMOUS = "anonymous";
    private String mUsername;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mUsername = ANONYMOUS;

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        mTextMessage =  findViewById(R.id.message);
        imageView =  findViewById(R.id.home_image);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        mAuth = FirebaseAuth.getInstance();

        //Authenticating Users
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //user signed-in
                    OnSignedIn(user.getDisplayName());
                   // Toast.makeText(MainActivity.this, "You are Signed-in as " + mUsername,Toast.LENGTH_SHORT).show();
                } else {
                    //user signed-out
                    OnSignedOut();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };



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
                            dialog_getBlood();
                        }
                    });
                    return true;
                case R.id.navigation_donate_blood:
                    mTextMessage.setText(R.string.title_donate_blood);
                    Glide.with(getApplicationContext()).load(R.drawable.home_donate_blood).into(imageView);

                    mTextMessage.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog_donateBlood();
                            //startActivity(new Intent(MainActivity.this, DonateBlood.class));
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



    public void dialog_getBlood(){
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


    public void dialog_donateBlood(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.dialog_donate_blood);
        alertDialogBuilder.setTitle("Donate Blood and Save Lives");
        alertDialogBuilder.setPositiveButton("Sure",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(MainActivity.this,DonateBlood.class);
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










    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener !=null){
            mAuth.removeAuthStateListener(mAuthStateListener);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        mAuth.addAuthStateListener(mAuthStateListener);
    }


    protected void OnSignedIn(String userName) {
        mUsername = userName;

    }

    protected void OnSignedOut() {
        mUsername = "Anonymous";

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sign_out_menu:
                //signout
                AuthUI.getInstance().signOut(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Signed-In", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign-In Cancelled", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }










}
