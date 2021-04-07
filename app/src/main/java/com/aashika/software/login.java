package com.aashika.software;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PatternMatcher;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(login.this);
    private EditText loginEmailText;
    private EditText loginPasswordText;
    private Button loginButton;
    private TextView forgotpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        //mAuth = FirebaseAuth.getInstance();
        loginEmailText = (EditText) findViewById(R.id.userEmail);
        loginPasswordText = (EditText) findViewById(R.id.userPassword);
        loginButton = (Button) findViewById(R.id.login_button);
        forgotpswd =  findViewById(R.id.forgot_pswd);
        forgotpswd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"admin@gmail.com"});
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Forgot Password! Requesting a new Password");
                intent.putExtra(Intent.EXTRA_TEXT , "Hello sir, \n\n Kindly reset my password as soon as possible ! \n\nThank you.");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginEmail = loginEmailText.getText().toString();
                String loginPassword = loginPasswordText.getText().toString();

                if(loginEmail.isEmpty())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Email id is required");
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(loginEmail).matches())
                {
                    loginEmailText.requestFocus();
                    loginEmailText.setError("Enter a valid email id");
                    return;
                }

                if(loginPassword.isEmpty())
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password is required");
                    return;
                }
                if(loginPassword.length()<6)
                {
                    loginPasswordText.requestFocus();
                    loginPasswordText.setError("Password length must be minimum 6");
                    return;
                }

                try {
                    String password = helper.searchPassword(loginEmail);
                    final ArrayList<String> list = helper.searchEmail(loginEmail);
                    if (list.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                    }
                    else if(password.equals(loginPassword)) {
                        Intent i = new Intent(login.this, NavBarActivity.class);
                        i.putExtra("EmailId", loginEmail);
                        startActivity(i);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"password & username doesn't match",Toast.LENGTH_LONG).show();
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    public void onBackPressed() {
        Intent i = new Intent(login.this, MainActivity.class);
        startActivity(i);
    }



}
