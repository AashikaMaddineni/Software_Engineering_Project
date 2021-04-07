package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class company_posted_jobs_updation extends AppCompatActivity {
    private String emailIdFromOtherClass;
    private EditText mJobId;
    private EditText mJobName;
    private EditText mJobType;
    private EditText mSalary;
    private Button mUpdateButton;
    private String name;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_post_jobs_updation);
        ScrollView mscrollView = (ScrollView) findViewById(R.id.post_jobs_scroll_id);
        mJobId = (EditText) findViewById(R.id.job_id);
        mJobName = (EditText) findViewById(R.id.job_name_id);
        mJobType = (EditText) findViewById(R.id.job_type_id);
        mSalary = (EditText) findViewById(R.id.salary_id);
        mUpdateButton = (Button) findViewById(R.id.update_post_jobs_button_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        id=getIntent().getExtras().getInt("Id");
        Log.v("email", emailIdFromOtherClass);
        DatabaseHelperCompany helper = new DatabaseHelperCompany(company_posted_jobs_updation.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        if(id==1) {
            mJobId.setText(list.get(9));
            mJobName.setText(list.get(10));
            mJobType.setText(list.get(11));
            mSalary.setText(list.get(12));
        }
        else if(id==2){
            mJobId.setText(list.get(13));
            mJobName.setText(list.get(14));
            mJobType.setText(list.get(15));
            mSalary.setText(list.get(16));

        }
        else if(id==3) {
            mJobId.setText(list.get(17));
            mJobName.setText(list.get(18));
            mJobType.setText(list.get(19));
            mSalary.setText(list.get(20));
        }
        else {
            mJobId.setText(list.get(21));
            mJobName.setText(list.get(22));
            mJobType.setText(list.get(23));
            mSalary.setText(list.get(24));
        }
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mJobId.getText().toString().isEmpty()) {
                    mJobId.requestFocus();
                    mJobId.setError("Job ID is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mJobName.getText().toString().isEmpty()) {
                    mJobName.requestFocus();
                    mJobName.setError("Job Name is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mJobType.getText().toString().isEmpty()) {
                    mJobType.requestFocus();
                    mJobType.setError("Job Type required");
                    return;
                }
                Log.v("tag", "hi");
                if (mSalary.getText().toString().isEmpty()) {
                    mSalary.requestFocus();
                    mSalary.setError("Job salary is required");
                    return;
                }
                Log.v("tag", "hi");

                if (mJobId.getText().toString().isEmpty() || mJobName.getText().toString().isEmpty() || mJobType.getText().toString().isEmpty() || mSalary.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Check all the fields filled/not",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    DatabaseHelperCompany helper = new DatabaseHelperCompany(company_posted_jobs_updation.this);
                    CompanyContact c = new CompanyContact();
                    if(id==1) {
                        c.setId(Integer.parseInt(list.get(0)));
                        c.setJobId1(Integer.parseInt(mJobId.getText().toString()));
                        c.setJobName1(mJobName.getText().toString());
                        c.setJobType1(mJobType.getText().toString());
                        c.setSalary1(Integer.parseInt(mSalary.getText().toString()));
                        helper.updatejobs1(c);
                        Intent i = new Intent(company_posted_jobs_updation.this, CompanyView_Posted_Jobs.class);
                        i.putExtra("EmailId", emailIdFromOtherClass);
                        i.putExtra("Name", name);
                        startActivity(i);
                        finish();
                    }
                    else if(id==2) {
                        c.setId(Integer.parseInt(list.get(0)));
                        c.setJobId2(Integer.parseInt(mJobId.getText().toString()));
                        c.setJobName2(mJobName.getText().toString());
                        c.setJobType2(mJobType.getText().toString());
                        c.setSalary2(Integer.parseInt(mSalary.getText().toString()));
                        helper.updatejobs2(c);
                        Intent i = new Intent(company_posted_jobs_updation.this, CompanyView_Posted_Jobs.class);
                        i.putExtra("EmailId", emailIdFromOtherClass);
                        i.putExtra("Name", name);
                        startActivity(i);
                        finish();
                    }
                    else if(id==3) {
                        c.setId(Integer.parseInt(list.get(0)));
                        c.setJobId3(Integer.parseInt(mJobId.getText().toString()));
                        c.setJobName3(mJobName.getText().toString());
                        c.setJobType3(mJobType.getText().toString());
                        c.setSalary3(Integer.parseInt(mSalary.getText().toString()));
                        helper.updatejobs3(c);
                        Intent i = new Intent(company_posted_jobs_updation.this, CompanyView_Posted_Jobs.class);
                        i.putExtra("EmailId", emailIdFromOtherClass);
                        i.putExtra("Name", name);
                        startActivity(i);
                        finish();
                    }
                    else {
                        c.setId(Integer.parseInt(list.get(0)));
                        c.setJobId4(Integer.parseInt(mJobId.getText().toString()));
                        c.setJobName4(mJobName.getText().toString());
                        c.setJobType4(mJobType.getText().toString());
                        c.setSalary4(Integer.parseInt(mSalary.getText().toString()));
                        helper.updatejobs4(c);
                        Intent i = new Intent(company_posted_jobs_updation.this, CompanyView_Posted_Jobs.class);
                        i.putExtra("EmailId", emailIdFromOtherClass);
                        i.putExtra("Name", name);
                        startActivity(i);
                        finish();
                    }
                }

            }
        });


    }


}

