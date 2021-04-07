package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class apply_jobs_from_search extends AppCompatActivity {
    private String emailIdFromOtherClass;
    private EditText mname;
    private EditText memailId;
    private EditText mcontactno;
    private EditText mgrade;
    private EditText mskill;
    private EditText maddress;
    private EditText mCompany;
    private EditText mCompanyEmail;
    private EditText jobName;
    private EditText jobId;
    private EditText jobType;
    private String name;
    private String Cemail;
    private int flag;

    private Button mbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.apply_jobs_from_search);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name=getIntent().getExtras().getString("Name");
        Cemail=getIntent().getExtras().getString("Cemail");
        flag=getIntent().getExtras().getInt("flag");

        ScrollView mscrollView = (ScrollView) findViewById(R.id.apply_for_jobs_scroll_id);
        mname = (EditText) findViewById(R.id.student_name);
        memailId = (EditText) findViewById(R.id.student_email);
        mcontactno = (EditText) findViewById(R.id.student_contact);
        mgrade = (EditText) findViewById(R.id.student_grade);
        mskill = (EditText) findViewById(R.id.student_skill);
        maddress = (EditText) findViewById(R.id.student_address);
        mCompany = (EditText) findViewById(R.id.job_company_name);
        mCompanyEmail = (EditText) findViewById(R.id.job_company_email_id);
        jobName = (EditText) findViewById(R.id.job_title_id);
        jobId = (EditText) findViewById(R.id.job_id_search);
        jobType = (EditText) findViewById(R.id.job_type_id_search);
        mbutton = (Button) findViewById(R.id.apply_for_jobs_button_id);
        DatabaseHelper helper = new DatabaseHelper(apply_jobs_from_search.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        mname.setText(list.get(1));
        memailId.setText(list.get(4));
        mcontactno.setText(list.get(5));
        mgrade .setText(list.get(10));
        mskill.setText(list.get(11));
        maddress.setText(list.get(7));

        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(apply_jobs_from_search.this);
        final ArrayList<String> list1 = helperCompany.searchEmail(Cemail);
        if(flag==1){
            mCompany.setText(list1.get(1));
            mCompanyEmail.setText(list1.get(4));
            jobId.setText(list1.get(9));
            jobName.setText(list1.get(10));
            jobType.setText(list1.get(11));
        }
        else if(flag==2) {
            mCompany.setText(list1.get(1));
            mCompanyEmail.setText(list1.get(4));
            jobId.setText(list1.get(13));
            jobName.setText(list1.get(14));
            jobType.setText(list1.get(15));
        }
        else if(flag==3) {
            mCompany.setText(list1.get(1));
            mCompanyEmail.setText(list1.get(4));
            jobId.setText(list1.get(17));
            jobName.setText(list1.get(18));
            jobType.setText(list1.get(19));
        }
        else {
            mCompany.setText(list1.get(1));
            mCompanyEmail.setText(list1.get(4));
            jobId.setText(list1.get(21));
            jobName.setText(list1.get(22));
            jobType.setText(list1.get(23));
        }
            mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentContact c = new StudentContact();
                c.setId(Integer.parseInt(list.get(0)));
                if(flag==1) {
                    helper.applyForJobfromsearch(1, emailIdFromOtherClass, mgrade.getText().toString(), mskill.getText().toString(), mCompany.getText().toString(), mCompanyEmail.getText().toString(), Integer.parseInt(jobId.getText().toString()), jobName.getText().toString(), jobType.getText().toString(), c);
                }
                else if(flag==2){
                    helper.applyForJobfromsearch(2, emailIdFromOtherClass, mgrade.getText().toString(), mskill.getText().toString(), mCompany.getText().toString(), mCompanyEmail.getText().toString(), Integer.parseInt(jobId.getText().toString()), jobName.getText().toString(), jobType.getText().toString(), c);
                }
                else if(flag==3){
                    helper.applyForJobfromsearch(3, emailIdFromOtherClass, mgrade.getText().toString(), mskill.getText().toString(), mCompany.getText().toString(), mCompanyEmail.getText().toString(), Integer.parseInt(jobId.getText().toString()), jobName.getText().toString(), jobType.getText().toString(), c);
                }
                else{
                    helper.applyForJobfromsearch(4, emailIdFromOtherClass, mgrade.getText().toString(), mskill.getText().toString(), mCompany.getText().toString(), mCompanyEmail.getText().toString(), Integer.parseInt(jobId.getText().toString()), jobName.getText().toString(), jobType.getText().toString(), c);
                }
                Intent i = new Intent(apply_jobs_from_search.this,SearchJobsNavBar.class);
                i.putExtra("EmailId",emailIdFromOtherClass);
                i.putExtra("Name",name);
                Toast.makeText(getApplicationContext(),"Applied for job successfully",Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{mCompanyEmail.getText().toString()});
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Job Application");
                intent.putExtra(Intent.EXTRA_TEXT , "Hello sir, \n\n Here is the issues I have faced in the posted application Kindly check the issue as soon as possible! \n\n Thank you.");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
 }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(apply_jobs_from_search.this,SearchJobsNavBar.class);
        i.putExtra("EmailId",emailIdFromOtherClass);
        i.putExtra("Name",name);
        startActivity(i);
    }
}
