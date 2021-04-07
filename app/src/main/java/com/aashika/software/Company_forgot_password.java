package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class Company_forgot_password extends AppCompatActivity {
    private EditText passwordEmail;
    private EditText newpswd;
    private EditText conformpswd;
    private Button resetPassword;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        passwordEmail= findViewById(R.id.etPasswordEmail);
        newpswd= findViewById(R.id.new_password_id);
        conformpswd= findViewById(R.id.new_confirm_password_id);
        resetPassword=findViewById(R.id.btnPasswordReset);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = passwordEmail.getText().toString().trim();
                if (useremail.equals("")) {
                    Toast.makeText(Company_forgot_password.this, "Please enter your registered Email ID", Toast.LENGTH_SHORT).show();
                } else {
                    if (passwordEmail.getText().toString().isEmpty()) {
                        passwordEmail.requestFocus();
                        passwordEmail.setError("Email id is required");
                        return;
                    }

                    if (newpswd.getText().toString().isEmpty()) {
                        newpswd.requestFocus();
                        newpswd.setError("Password is required");
                        return;
                    }
                    if (conformpswd.getText().toString().isEmpty()) {
                        conformpswd.requestFocus();
                        conformpswd.setError("Re-enter password is required");
                        return;
                    } else {
                        DatabaseHelperCompany helper = new DatabaseHelperCompany(Company_forgot_password.this);
                        if (newpswd.getText().toString().isEmpty()) {
                            newpswd.requestFocus();
                            newpswd.setError("Password is required");
                            return;
                        }
                        if (newpswd.getText().toString().length() < 6) {
                            newpswd.requestFocus();
                            newpswd.setError("Password length must be minimum 6");
                            return;
                        }

                        if (conformpswd.getText().toString().isEmpty()) {
                            conformpswd.requestFocus();
                            conformpswd.setError("Password is required");
                            return;
                        }
                        if (conformpswd.getText().toString().length() < 6) {
                            conformpswd.requestFocus();
                            conformpswd.setError("Password length must be minimum 6");
                            return;
                        }
                        if (newpswd.getText().toString().equals(conformpswd.getText().toString())) {
                            try {
                                final ArrayList<String> list = helper.searchEmail(passwordEmail.getText().toString());

                                CompanyContact c = new CompanyContact();
                                c.setId(Integer.parseInt(list.get(0)));
                                c.setName(list.get(1));
                                c.setUname(list.get(2));
                                c.setUid(list.get(3));
                                c.setEmailId(list.get(4));
                                c.setContactNo(list.get(5));
                                c.setPassword(list.get(6));
                                c.setAddress(list.get(7));
                                helper.changePassword(newpswd.getText().toString(), passwordEmail.getText().toString(), c);
                                Intent i = new Intent(Company_forgot_password.this, login.class);
                                i.putExtra("EmailId", passwordEmail.getText().toString());
                                Toast.makeText(getApplicationContext(), "Password changed successfully", Toast.LENGTH_LONG).show();
                                startActivity(i);
                            }
                            catch (Exception e){
                                Toast.makeText(getApplicationContext(), "No user found please SignUp", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        });
    }
    public void onBackPressed() {
        Intent i = new Intent(Company_forgot_password.this, login.class);
        startActivity(i);
    }
}


