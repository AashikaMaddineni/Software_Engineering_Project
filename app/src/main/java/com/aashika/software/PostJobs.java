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
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PostJobs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private String emailIdFromOtherClass;
    private EditText mJobId;
    private EditText mJobName;
    private EditText mJobType;
    private EditText mSalary;
    private Button mUpdateButton;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_jobs);
        ScrollView mscrollView = (ScrollView) findViewById(R.id.post_jobs_scroll_id);

        mJobId = (EditText) findViewById(R.id.job_id);
        mJobName = (EditText) findViewById(R.id.job_name_id);
        mJobType = (EditText) findViewById(R.id.job_type_id);
        mSalary = (EditText) findViewById(R.id.salary_id);
        mUpdateButton = (Button) findViewById(R.id.update_post_jobs_button_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        Log.v("email",emailIdFromOtherClass);
        mUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String JobId =  mJobId.getText().toString();
                String JobName = mJobName.getText().toString();
                String JobType =  mJobType.getText().toString();
                String JobSalary = mSalary.getText().toString();
                if(JobId.isEmpty())
                {
                    mJobId.requestFocus();
                    mJobId.setError("Job id is required");
                    return;
                }
                if(JobId.matches("1000"))
                {
                    mJobId.requestFocus();
                    mJobId.setError("Job id pattern must be 1001");
                    return;
                }
                if(JobId.length()!=4)
                {
                    mJobId.requestFocus();
                    mJobId.setError("Job id must be of length 4");
                    return;
                }
                if(JobName.isEmpty())
                {
                    mJobName.requestFocus();
                    mJobName.setError("Job Name is required");
                    return;
                }
                if(JobType.isEmpty())
                {
                    mJobType.requestFocus();
                    mJobType.setError("Job Type is required");
                    return;
                }
                if(JobSalary.isEmpty())
                {
                    mSalary.requestFocus();
                    mSalary.setError("Job Salary is required");
                    return;
                }

                try {
                    DatabaseHelperCompany helper = new DatabaseHelperCompany(PostJobs.this);
                    final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
                    CompanyContact c = new CompanyContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(list.get(1));
                    c.setUname(list.get(2));
                    c.setUid(list.get(3));
                    c.setEmailId(list.get(4));
                    c.setContactNo(list.get(5));
                    c.setPassword(list.get(6));
                    c.setAddress(list.get(7));
                    c.setRank(list.get(8));
                    helper.postJobs(emailIdFromOtherClass, Integer.parseInt(mJobId.getText().toString()), mJobName.getText().toString(), mJobType.getText().toString(), Integer.parseInt(mSalary.getText().toString()), c);
                    Intent i = new Intent(PostJobs.this, CompanyView_Posted_Jobs.class);
                    i.putExtra("EmailId", emailIdFromOtherClass);
                    i.putExtra("Name", name);
                    Toast.makeText(getApplicationContext(), "Job posted successfully", Toast.LENGTH_LONG).show();
                    startActivity(i);
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(), "Check all details filled/not", Toast.LENGTH_LONG).show();
                }
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header=navigationView.getHeaderView(0);
        TextView Name = (TextView)header.findViewById(R.id.Photoname);
        Name.setText(name);
        TextView email = (TextView)header.findViewById(R.id.Photomail);
        email.setText(emailIdFromOtherClass);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.post_jobs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            //mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), loginCompany.class));
            finish();
            return true;
        }
        else if(id==R.id.help)
        {
            startActivity(new Intent(getApplicationContext(),companyHelp.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        int id = item.getItemId();
        if (id == R.id.company_home )
        {
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
           drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_viewjobs) {
            // startActivity(new Intent(getApplicationContext(),PostJobs.class));
            //finish();
            Intent i = new Intent(getApplicationContext(),CompanyView_Posted_Jobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        }
        else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            //startActivity(new Intent(getApplicationContext(),ChangePasswordNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
