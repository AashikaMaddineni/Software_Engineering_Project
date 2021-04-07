package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class doSignUp extends AppCompatActivity {

    private EditText mUserFullName;
    private EditText mUserName;
    private EditText mUserId;
    private EditText mUserEmailId;
    private EditText mUserContactNo;
    private EditText mUserPassword;
    private EditText mUserConfirmPassword;
    private Button mSignUpButton;
    private String email;
    private String password;
    private String confirmPassword;
    private Spinner spinner;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_sign_up);
        mUserFullName = (EditText) findViewById(R.id.UserFullName);
        mUserName = (EditText) findViewById(R.id.Username);
        mUserId = (EditText) findViewById(R.id.userId);
        mUserEmailId = (EditText) findViewById(R.id.userEmailId);
        mUserContactNo = (EditText) findViewById(R.id.userContactNo);
        mUserPassword = (EditText) findViewById(R.id.userPassword);
        mUserConfirmPassword = (EditText) findViewById(R.id.userConfirmPassword);


        /**code for spinner**/
        final Spinner spinner = (Spinner) findViewById(R.id.signup_spinner_id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(doSignUp.this,R.array.signup_spinner_id,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s = adapterView.getSelectedItem().toString();
                Log.v("string",s);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSignUpButton = (Button) findViewById(R.id.signUpButton);

        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mUserFullName.getText().toString().isEmpty())
                {
                    mUserFullName.requestFocus();
                    mUserFullName.setError("Full Name is required");
                    return;
                }
                if(mUserName.getText().toString().isEmpty())
                {
                    mUserName.requestFocus();
                    mUserName.setError("UserName is required");
                    return;
                }
                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("UserId is required");
                    return;
                }


                email = mUserEmailId.getText().toString();
                password = mUserPassword.getText().toString();
                confirmPassword = mUserConfirmPassword.getText().toString();

                if(email.isEmpty()){
                    mUserEmailId.requestFocus();
                    mUserEmailId.setError("email id is required");
                    return;

                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    mUserEmailId.requestFocus();
                    mUserEmailId.setError("Enter  a valid email id");
                    return;
                }

                if(mUserContactNo.getText().toString().isEmpty())
                {
                    mUserContactNo.requestFocus();
                    mUserContactNo.setError("User Contact No is required");
                    return;
                }

                if(password.isEmpty()){
                    mUserPassword.requestFocus();
                    mUserPassword.setError("Password is required");
                    return;
                }

                if(confirmPassword.length()<6)
                {
                    mUserConfirmPassword.requestFocus();
                    mUserConfirmPassword.setError("Password length must be minimum 6");
                    return;
                }
                Log.v("password",password);
                Log.v("cpassword",confirmPassword);
                if(password.equals(confirmPassword)) {

                    if (s.equals("Student")) {

                        StudentContact c = new StudentContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelper helper = new DatabaseHelper(doSignUp.this);
                        helper.insertStudentContact(c);
                        startActivity(new Intent(getApplicationContext(),login.class));
                    }
                    else if(s.equals("Company"))
                    {

                        CompanyContact c = new CompanyContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperCompany helper = new DatabaseHelperCompany(doSignUp.this);
                        helper.insertCompanyContact(c);
                        startActivity(new Intent(getApplicationContext(),loginCompany.class));
                    }
                    else if(s.equals("Admin"))
                    {

                        AdminContact c = new AdminContact();
                        c.setName(mUserFullName.getText().toString());
                        c.setUname(mUserName.getText().toString());
                        c.setUid(mUserId.getText().toString());
                        c.setEmailId(mUserEmailId.getText().toString());
                        c.setContactNo(mUserContactNo.getText().toString());
                        c.setPassword(mUserPassword.getText().toString());
                        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(doSignUp.this);
                        helper.insertAdminContact(c);
                        startActivity(new Intent(getApplicationContext(),loginAdmin.class));
                    }
                }
                else
                {
                    Toast.makeText(doSignUp.this, "Confirm Password & Password doesn't match",Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        /*FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            // kuch to karenge
        }*/
    }
}
