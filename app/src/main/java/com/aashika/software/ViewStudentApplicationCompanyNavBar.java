package com.aashika.software;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ViewStudentApplicationCompanyNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emailIdFromOtherClass;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student_application_company_nav_bar);

        ScrollView mscrollView = (ScrollView) findViewById(R.id.view_student_application_company_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.view_student_application_company_linear_layout_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        DatabaseHelper helper = new DatabaseHelper(ViewStudentApplicationCompanyNavBar.this);
        List<StudentContact> studentList = helper.getAllStudent();
        TextView textView0 = new TextView(ViewStudentApplicationCompanyNavBar.this);
        textView0.setTextSize(20);
        textView0.setText(" * * * * * * * * * Applications * * * * * * * * \n");
        textView0.setTextColor(Color.parseColor("#000000"));
        textView0.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        textView0.setGravity(Gravity.CENTER);
        linearLayout.addView(textView0);


        for (int i = 0; i < studentList.size(); i++) {
            StudentContact c = studentList.get(i);

            if (c.getCompanyEmail1() != null && c.getCompanyEmail1().equals(emailIdFromOtherClass)) {
                TextView textView1 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1.setTextSize(16);
                textView1.setText(" Student Name: " + c.getName());
                textView1.setTextColor(Color.parseColor("#000000"));
                textView1.setTypeface(Typeface.SANS_SERIF);
                linearLayout.addView(textView1);

                TextView textView2 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2.setTextSize(16);
                textView2.setText(" Job Name: " + c.getJobName1());
                textView2.setTextColor(Color.parseColor("#000000"));
                textView2.setTypeface(Typeface.SANS_SERIF);
                linearLayout.addView(textView2);

                TextView textView3 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3.setTextSize(16);
                textView3.setTextColor(Color.parseColor("#000000"));
                textView3.setTypeface(Typeface.SANS_SERIF);
                textView3.setText(" Job Id: " + c.getJobId1());
                linearLayout.addView(textView3);

                TextView textView4 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4.setTextSize(16);
                textView4.setTextColor(Color.parseColor("#000000"));
                textView4.setTypeface(Typeface.SANS_SERIF);
                textView4.setText(" Job Type: " + c.getJobType1());
                linearLayout.addView(textView4);

                TextView textView5 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5.setTextSize(16);
                textView5.setTextColor(Color.parseColor("#000000"));
                textView5.setTypeface(Typeface.SANS_SERIF);
                textView5.setText(" Student EmailId: " + c.getEmailId());
                linearLayout.addView(textView5);

                TextView textView6 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6.setTextSize(16);
                textView6.setTextColor(Color.parseColor("#000000"));
                textView6.setTypeface(Typeface.SANS_SERIF);
                textView6.setText(" Student ContactNo: " + c.getContactNo());
                linearLayout.addView(textView6);

                TextView textView7 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7.setTextSize(16);
                textView7.setTextColor(Color.parseColor("#000000"));
                textView7.setTypeface(Typeface.SANS_SERIF);
                textView7.setText(" Student Grade: " + c.getGrade());
                linearLayout.addView(textView7);

                TextView textView8 = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8.setTextSize(16);
                textView8.setTextColor(Color.parseColor("#000000"));
                textView8.setTypeface(Typeface.SANS_SERIF);
                textView8.setText(" Student Skill: " + c.getSkill() + "\n");
                linearLayout.addView(textView8);


                RadioGroup rg = new RadioGroup(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(250, 0, 0, 0);
                rg.setLayoutParams(params);
                String []array={"Select", "Reject"};
                rg.setOrientation(RadioGroup.HORIZONTAL);
                for(int j=0; j<2; j++){
                    RadioButton rb  = new RadioButton(this);
                    rb.setText(array[j]);
                    rb.setId(j);
                    rg.addView(rb);
                    rb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((RadioGroup) v.getParent()).check(v.getId());
                            if(v.getId()==0){
                                helper.clearstatus1(c);
                                c.setQualified1(true);
                                Toast.makeText(getApplicationContext(), "Clicked true", Toast.LENGTH_LONG).show();
                                helper.status1(c);
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{c.getEmailId()});
                                intent.setType("message/rfc822");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Job Application");
                                intent.putExtra(Intent.EXTRA_TEXT , "Dear student, \n\n Congratulations, you have been selected for the "+c.getJobName1()+" position in the company " +name+" for the further communication kindly upload the resume as soon as possible! \n\n Thank you.");
                                startActivity(Intent.createChooser(intent, "Choose an email client"));
                            }
                            else{
                                helper.clearstatus1(c);
                                c.setQualified1(false);
                                Toast.makeText(getApplicationContext(), "Clicked false", Toast.LENGTH_LONG).show();
                                helper.status1(c);
                            }
                        }
                    });
                }
                linearLayout.addView(rg);
            }
        }


        for(int i = 0; i<studentList.size();i++)    {
        StudentContact c = studentList.get(i);
        if (c.getCompanyEmail2() != null && (c.getCompanyEmail2()).equals(emailIdFromOtherClass)) {

            TextView textView9 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView9.setTextSize(16);
            textView9.setTextColor(Color.parseColor("#000000"));
            textView9.setTypeface(Typeface.SANS_SERIF);
            textView9.setText(" Student Name: " + c.getName());
            linearLayout.addView(textView9);

            TextView textView10 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView10.setTextSize(16);
            textView10.setTextColor(Color.parseColor("#000000"));
            textView10.setTypeface(Typeface.SANS_SERIF);
            textView10.setText(" Job Name: " + c.getJobName2());
            linearLayout.addView(textView10);

            TextView textView11 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView11.setTextSize(16);
            textView11.setTextColor(Color.parseColor("#000000"));
            textView11.setTypeface(Typeface.SANS_SERIF);
            textView11.setText(" Job Id: " + c.getJobId2());
            linearLayout.addView(textView11);

            TextView textView12 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView12.setTextSize(16);
            textView12.setTextColor(Color.parseColor("#000000"));
            textView12.setTypeface(Typeface.SANS_SERIF);
            textView12.setText(" Job Type: " + c.getJobType2());
            linearLayout.addView(textView12);

            TextView textView13 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView13.setTextSize(16);
            textView13.setTextColor(Color.parseColor("#000000"));
            textView13.setTypeface(Typeface.SANS_SERIF);
            textView13.setText(" Student EmailId: " + c.getEmailId());
            linearLayout.addView(textView13);

            TextView textView14 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView14.setTextSize(16);
            textView14.setTextColor(Color.parseColor("#000000"));
            textView14.setTypeface(Typeface.SANS_SERIF);
            textView14.setText(" Student ContactNo: " + c.getContactNo());
            linearLayout.addView(textView14);

            TextView textView15 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView15.setTextSize(16);
            textView15.setTextColor(Color.parseColor("#000000"));
            textView15.setTypeface(Typeface.SANS_SERIF);
            textView15.setText(" Student Grade: " + c.getGrade());
            linearLayout.addView(textView15);

            TextView textView16 = new TextView(ViewStudentApplicationCompanyNavBar.this);
            textView16.setTextSize(16);
            textView16.setTextColor(Color.parseColor("#000000"));
            textView16.setTypeface(Typeface.SANS_SERIF);
            textView16.setText(" Student Skill: " + c.getSkill() + "\n");
            linearLayout.addView(textView16);

            RadioGroup rg = new RadioGroup(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(250, 0, 0, 0);
            rg.setLayoutParams(params);
            String []array={"Select", "Reject"};
            rg.setOrientation(RadioGroup.HORIZONTAL);
            for(int j=0; j<2; j++){
                RadioButton rb  = new RadioButton(this);
                rb.setText(array[j]);
                rb.setId(j);
                rg.addView(rb);
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((RadioGroup) v.getParent()).check(v.getId());
                        if(v.getId()==0){
                            helper.clearstatus2(c);
                            c.setQualified2(Boolean.TRUE);
                            Toast.makeText(getApplicationContext(), "Clicked true", Toast.LENGTH_LONG).show();
                            helper.status2(c);
                                    Intent intent = new Intent(Intent.ACTION_SEND);
                                    intent.putExtra(Intent.EXTRA_EMAIL,new String[]{c.getEmailId()});
                                    intent.setType("message/rfc822");
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Job Application");
                                    intent.putExtra(Intent.EXTRA_TEXT , "Dear student, \n\n Congratulations, you have been selected for the "+c.getJobName2()+" position in the company " +name+" for the further communication kindly upload the resume as soon as possible! \n\n Thank you.");
                                    startActivity(Intent.createChooser(intent, "Choose an email client"));

                        }
                        else{
                            helper.clearstatus2(c);
                            c.setQualified2(Boolean.FALSE);
                            Toast.makeText(getApplicationContext(), "Clicked false", Toast.LENGTH_LONG).show();
                            helper.status2(c);
                        }
                    }
                });
            }
            linearLayout.addView(rg);

        }
    }

        for(int i=0; i<studentList.size();i++) {
            StudentContact c = studentList.get(i);
            if (c.getCompanyEmail3() != null && c.getCompanyEmail3().equals(emailIdFromOtherClass)) {
                TextView textView1a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1a.setTextSize(16);
                textView1a.setTextColor(Color.parseColor("#000000"));
                textView1a.setTypeface(Typeface.SANS_SERIF);
                textView1a.setText("Student Name: " + c.getName());
                linearLayout.addView(textView1a);

                TextView textView2a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2a.setTextSize(16);
                textView2a.setTextColor(Color.parseColor("#000000"));
                textView2a.setTypeface(Typeface.SANS_SERIF);
                textView2a.setText("Job Name: " + c.getJobName3());
                linearLayout.addView(textView2a);

                TextView textView3a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3a.setTextSize(16);
                textView3a.setTextColor(Color.parseColor("#000000"));
                textView3a.setTypeface(Typeface.SANS_SERIF);
                textView3a.setText("Job Id: " + c.getJobId3());
                linearLayout.addView(textView3a);

                TextView textView4a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4a.setTextSize(16);
                textView4a.setTextColor(Color.parseColor("#000000"));
                textView4a.setTypeface(Typeface.SANS_SERIF);
                textView4a.setText("Job Type: " + c.getJobType3());
                linearLayout.addView(textView4a);

                TextView textView5a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5a.setTextSize(16);
                textView5a.setTextColor(Color.parseColor("#000000"));
                textView5a.setTypeface(Typeface.SANS_SERIF);
                textView5a.setText("Student EmailId: " + c.getEmailId());
                linearLayout.addView(textView5a);

                TextView textView6a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6a.setTextSize(16);
                textView6a.setTextColor(Color.parseColor("#000000"));
                textView6a.setTypeface(Typeface.SANS_SERIF);
                textView6a.setText("Student ContactNo: " + c.getContactNo());
                linearLayout.addView(textView6a);

                TextView textView7a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7a.setTextSize(16);
                textView7a.setTextColor(Color.parseColor("#000000"));
                textView7a.setTypeface(Typeface.SANS_SERIF);
                textView7a.setText("Student Grade: " + c.getGrade());
                linearLayout.addView(textView7a);

                TextView textView8a = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8a.setTextSize(16);
                textView8a.setTextColor(Color.parseColor("#000000"));
                textView8a.setTypeface(Typeface.SANS_SERIF);
                textView8a.setText("Student Skill: " + c.getSkill() + "\n");
                linearLayout.addView(textView8a);

                RadioGroup rg = new RadioGroup(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(250, 0, 0, 0);
                rg.setLayoutParams(params);
                String []array={"Select", "Reject"};
                rg.setOrientation(RadioGroup.HORIZONTAL);
                for(int j=0; j<2; j++){
                    RadioButton rb  = new RadioButton(this);
                    rb.setText(array[j]);
                    rb.setId(j);
                    rg.addView(rb);
                    rb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((RadioGroup) v.getParent()).check(v.getId());
                            if(v.getId()==0){
                                helper.clearstatus3(c);
                                c.setQualified3(true);
                                Toast.makeText(getApplicationContext(), "Clicked true", Toast.LENGTH_LONG).show();
                                helper.status3(c);
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{c.getEmailId()});
                                intent.setType("message/rfc822");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Job Application");
                                intent.putExtra(Intent.EXTRA_TEXT , "Dear student, \n\n Congratulations, you have been selected for the "+c.getJobName3()+" position in the company " +name+" for the further communication kindly upload the resume as soon as possible! \n\n Thank you.");
                                startActivity(Intent.createChooser(intent, "Choose an email client"));
                            }
                            else{
                                helper.clearstatus3(c);
                                c.setQualified3(false);
                                Toast.makeText(getApplicationContext(), "Clicked false", Toast.LENGTH_LONG).show();
                                helper.status3(c);
                            }
                        }
                    });
                }
                linearLayout.addView(rg);

            }
        }

        for(int i=0; i<studentList.size();i++) {
            StudentContact c = studentList.get(i);
            if (c.getCompanyEmail4() != null && c.getCompanyEmail4().equals(emailIdFromOtherClass)) {
                TextView textView1b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView1b.setTextSize(16);
                textView1b.setTextColor(Color.parseColor("#000000"));
                textView1b.setTypeface(Typeface.SANS_SERIF);
                textView1b.setText("Student Name: " + c.getName());
                linearLayout.addView(textView1b);

                TextView textView2b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView2b.setTextSize(16);
                textView2b.setTextColor(Color.parseColor("#000000"));
                textView2b.setTypeface(Typeface.SANS_SERIF);
                textView2b.setText("Job Name: " + c.getJobName4());
                linearLayout.addView(textView2b);

                TextView textView3b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView3b.setTextSize(16);
                textView3b.setTextColor(Color.parseColor("#000000"));
                textView3b.setTypeface(Typeface.SANS_SERIF);
                textView3b.setText("Job Id: " + c.getJobId4());
                linearLayout.addView(textView3b);

                TextView textView4b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView4b.setTextSize(16);
                textView4b.setTextColor(Color.parseColor("#000000"));
                textView4b.setTypeface(Typeface.SANS_SERIF);
                textView4b.setText("Job Type: " + c.getJobType4());
                linearLayout.addView(textView4b);

                TextView textView5b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView5b.setTextSize(16);
                textView5b.setTextColor(Color.parseColor("#000000"));
                textView5b.setTypeface(Typeface.SANS_SERIF);
                textView5b.setText("Student EmailId: " + c.getEmailId());
                linearLayout.addView(textView5b);

                TextView textView6b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView6b.setTextSize(16);
                textView6b.setTextColor(Color.parseColor("#000000"));
                textView6b.setTypeface(Typeface.SANS_SERIF);
                textView6b.setText("Student ContactNo: " + c.getContactNo());
                linearLayout.addView(textView6b);

                TextView textView7b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView7b.setTextSize(16);
                textView7b.setTextColor(Color.parseColor("#000000"));
                textView7b.setTypeface(Typeface.SANS_SERIF);
                textView7b.setText("Student Grade: " + c.getGrade());
                linearLayout.addView(textView7b);

                TextView textView8b = new TextView(ViewStudentApplicationCompanyNavBar.this);
                textView8b.setTextSize(16);
                textView8b.setTextColor(Color.parseColor("#000000"));
                textView8b.setTypeface(Typeface.SANS_SERIF);
                textView8b.setText("Student Skill: " + c.getSkill() + "\n");
                linearLayout.addView(textView8b);

                RadioGroup rg = new RadioGroup(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.setMargins(250, 0, 0, 0);
                rg.setLayoutParams(params);
                String []array={"Select", "Reject"};
                rg.setOrientation(RadioGroup.HORIZONTAL);
                for(int j=0; j<2; j++){
                    RadioButton rb  = new RadioButton(this);
                    rb.setText(array[j]);
                    rb.setId(j);
                    rg.addView(rb);
                    rb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((RadioGroup) v.getParent()).check(v.getId());
                            if(v.getId()==0){
                                helper.clearstatus4(c);
                                c.setQualified4(Boolean.TRUE);
                                Toast.makeText(getApplicationContext(), "Clicked true", Toast.LENGTH_LONG).show();
                                helper.status4(c);
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{c.getEmailId()});
                                intent.setType("message/rfc822");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Job Application");
                                intent.putExtra(Intent.EXTRA_TEXT , "Dear student, \n\n Congratulations, you have been selected for the "+c.getJobName4()+" position in the company " +name+" for the further communication kindly upload the resume as soon as possible! \n\n Thank you.");
                                startActivity(Intent.createChooser(intent, "Choose an email client"));

                            }
                            else{
                                helper.clearstatus4(c);
                                c.setQualified4(Boolean.FALSE);
                                Toast.makeText(getApplicationContext(), "Clicked false", Toast.LENGTH_LONG).show();
                                helper.status4(c);
                            }
                        }
                    });
                }
                linearLayout.addView(rg);

            }

        }


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
        getMenuInflater().inflate(R.menu.view_student_application_company_nav_bar, menu);
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
//            mAuth.signOut();
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
//            startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
//            startActivity(new Intent(getApplicationContext(),PostJobs.class));
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            //finish();
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
//            startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));
            Intent i = new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } /*else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(getApplicationContext(),SearchJobsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }*/ else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            //startActivity(new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class));
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
