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
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewJobStatusNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //private FirebaseAuth mAuth;
    private String emailIdFromOtherClass;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_job_status_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name= getIntent().getExtras().getString("Name");

        ScrollView mscrollView = (ScrollView) findViewById(R.id.view_job_status_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.view_job_status_layout_id);

        DatabaseHelper helper = new DatabaseHelper(ViewJobStatusNavBar.this);
        List<StudentContact> studentList = helper.getAllStudent();
        TextView textView0 = new TextView(ViewJobStatusNavBar.this);
        textView0.setTextSize(20);
        textView0.setText(" * * * * * * Status of Applied Jobs * * * * * * \n");
        textView0.setTextColor(Color.parseColor("#000000"));
        textView0.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        textView0.setGravity(Gravity.CENTER);
        linearLayout.addView(textView0);
        for (int i = 0; i < studentList.size(); i++) {
            StudentContact c = studentList.get(i);
            if (c.getEmailId().equals(emailIdFromOtherClass)) {
                if(c.getJobId1()!=null) {
                    TextView textView1 = new TextView(ViewJobStatusNavBar.this);
                    textView1.setTextSize(16);
                    textView1.setText(" Company Name: " + c.getCompanyName1());
                    textView1.setTextColor(Color.parseColor("#000000"));
                    textView1.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView1);

                    TextView textView2 = new TextView(ViewJobStatusNavBar.this);
                    textView2.setTextSize(16);
                    textView2.setText(" Job Name: " + c.getJobName1());
                    textView2.setTextColor(Color.parseColor("#000000"));
                    textView2.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView2);

                    TextView textView3 = new TextView(ViewJobStatusNavBar.this);
                    textView3.setTextSize(16);
                    textView3.setTextColor(Color.parseColor("#000000"));
                    textView3.setTypeface(Typeface.SANS_SERIF);
                    textView3.setText(" Job Id: " + c.getJobId1());
                    linearLayout.addView(textView3);

                    TextView textView4 = new TextView(ViewJobStatusNavBar.this);
                    textView4.setTextSize(16);
                    textView4.setTextColor(Color.parseColor("#000000"));
                    textView4.setTypeface(Typeface.SANS_SERIF);
                    textView4.setText(" Job Type: " + c.getJobType1());
                    linearLayout.addView(textView4);

                    TextView textViewh = new TextView(ViewJobStatusNavBar.this);
                    textViewh.setTextSize(16);
                    textViewh.setTextColor(Color.parseColor("#000000"));
                    textViewh.setTypeface(Typeface.SANS_SERIF);
                    textViewh.setText(" Job Status: Applied"+"\n-------------------------------------------------------------\n");
                    linearLayout.addView(textViewh);

                    if (c.getQualified1()==true) {
                        textViewh.setText(" Job Status: Selected"+"\n-------------------------------------------------------------\n");
                    }
                    else if(c.getQualified1()==false){
                        textViewh.setText(" Job Status: Rejected"+"\n-------------------------------------------------------------\n");

                    }
                }


                if(c.getJobId2()!=null) {
                    TextView textView1 = new TextView(ViewJobStatusNavBar.this);
                    textView1.setTextSize(16);
                    textView1.setText(" Company Name: " + c.getCompanyName2());
                    textView1.setTextColor(Color.parseColor("#000000"));
                    textView1.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView1);

                    TextView textView2 = new TextView(ViewJobStatusNavBar.this);
                    textView2.setTextSize(16);
                    textView2.setText(" Job Name: " + c.getJobName2());
                    textView2.setTextColor(Color.parseColor("#000000"));
                    textView2.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView2);

                    TextView textView3 = new TextView(ViewJobStatusNavBar.this);
                    textView3.setTextSize(16);
                    textView3.setTextColor(Color.parseColor("#000000"));
                    textView3.setTypeface(Typeface.SANS_SERIF);
                    textView3.setText(" Job Id: " + c.getJobId2());
                    linearLayout.addView(textView3);

                    TextView textView4 = new TextView(ViewJobStatusNavBar.this);
                    textView4.setTextSize(16);
                    textView4.setTextColor(Color.parseColor("#000000"));
                    textView4.setTypeface(Typeface.SANS_SERIF);
                    textView4.setText(" Job Type: " + c.getJobType2());                    linearLayout.addView(textView4);


                    TextView textViewh = new TextView(ViewJobStatusNavBar.this);
                    textViewh.setTextSize(16);
                    textViewh.setTextColor(Color.parseColor("#000000"));
                    textViewh.setTypeface(Typeface.SANS_SERIF);
                    textViewh.setText(" Job Status: Applied"+"\n-------------------------------------------------------------\n");
                    linearLayout.addView(textViewh);

                    if (c.getQualified2()==true) {
                        textViewh.setText(" Job Status: Selected"+"\n-------------------------------------------------------------\n");
                    }
                    else if(c.getQualified2()==false){
                        textViewh.setText(" Job Status: Rejected"+"\n-------------------------------------------------------------\n");

                    }
                }


                if(c.getJobId3()!=null) {
                    TextView textView1 = new TextView(ViewJobStatusNavBar.this);
                    textView1.setTextSize(16);
                    textView1.setText(" Company Name: " + c.getCompanyName3());
                    textView1.setTextColor(Color.parseColor("#000000"));
                    textView1.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView1);

                    TextView textView2 = new TextView(ViewJobStatusNavBar.this);
                    textView2.setTextSize(16);
                    textView2.setText(" Job Name: " + c.getJobName3());
                    textView2.setTextColor(Color.parseColor("#000000"));
                    textView2.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView2);

                    TextView textView3 = new TextView(ViewJobStatusNavBar.this);
                    textView3.setTextSize(16);
                    textView3.setTextColor(Color.parseColor("#000000"));
                    textView3.setTypeface(Typeface.SANS_SERIF);
                    textView3.setText(" Job Id: " + c.getJobId3());
                    linearLayout.addView(textView3);

                    TextView textView4 = new TextView(ViewJobStatusNavBar.this);
                    textView4.setTextSize(16);
                    textView4.setTextColor(Color.parseColor("#000000"));
                    textView4.setTypeface(Typeface.SANS_SERIF);
                    textView4.setText(" Job Type: " + c.getJobType3());
                    linearLayout.addView(textView4);

                    if (c.getQualified3() == Boolean.TRUE) {
                        TextView textView5 = new TextView(ViewJobStatusNavBar.this);
                        textView5.setTextSize(16);
                        textView5.setTextColor(Color.parseColor("#000000"));
                        textView5.setTypeface(Typeface.SANS_SERIF);
                        textView5.setText(" Job Status: Selected"+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textView5);
                    } else if(c.getQualified3() == Boolean.FALSE) {
                        TextView textView5 = new TextView(ViewJobStatusNavBar.this);
                        textView5.setTextSize(16);
                        textView5.setTextColor(Color.parseColor("#000000"));
                        textView5.setTypeface(Typeface.SANS_SERIF);
                        textView5.setText(" Job Status: Hired"+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textView5);
                    }
                }

                if(c.getJobId4()!=null) {
                    TextView textView1 = new TextView(ViewJobStatusNavBar.this);
                    textView1.setTextSize(16);
                    textView1.setText(" Company Name: " + c.getCompanyName4());
                    textView1.setTextColor(Color.parseColor("#000000"));
                    textView1.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView1);

                    TextView textView2 = new TextView(ViewJobStatusNavBar.this);
                    textView2.setTextSize(16);
                    textView2.setText(" Job Name: " + c.getJobName4());
                    textView2.setTextColor(Color.parseColor("#000000"));
                    textView2.setTypeface(Typeface.SANS_SERIF);
                    linearLayout.addView(textView2);

                    TextView textView3 = new TextView(ViewJobStatusNavBar.this);
                    textView3.setTextSize(16);
                    textView3.setTextColor(Color.parseColor("#000000"));
                    textView3.setTypeface(Typeface.SANS_SERIF);
                    textView3.setText(" Job Id: " + c.getJobId4());
                    linearLayout.addView(textView3);

                    TextView textView4 = new TextView(ViewJobStatusNavBar.this);
                    textView4.setTextSize(16);
                    textView4.setTextColor(Color.parseColor("#000000"));
                    textView4.setTypeface(Typeface.SANS_SERIF);
                    textView4.setText(" Job Type: " + c.getJobType4());
                    linearLayout.addView(textView4);

                    if (c.getQualified4() == Boolean.TRUE) {
                        TextView textView5 = new TextView(ViewJobStatusNavBar.this);
                        textView5.setTextSize(16);
                        textView5.setTextColor(Color.parseColor("#000000"));
                        textView5.setTypeface(Typeface.SANS_SERIF);
                        textView5.setText(" Job Status: Selected"+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textView5);
                    } else if(c.getQualified4() == Boolean.FALSE) {
                        TextView textView5 = new TextView(ViewJobStatusNavBar.this);
                        textView5.setTextSize(16);
                        textView5.setTextColor(Color.parseColor("#000000"));
                        textView5.setTypeface(Typeface.SANS_SERIF);
                        textView5.setText(" Job Status: Hired"+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textView5);
                    }
                }
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
        getMenuInflater().inflate(R.menu.view_job_status_nav_bar, menu);
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
            startActivity(new Intent(ViewJobStatusNavBar.this, login.class));
            finish();
            return true;
        }

        else if(id==R.id.help)
        {
            startActivity(new Intent(getApplicationContext(),studentHelp.class));
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

        if (id == R.id.student_home )
        {
            /*startActivity(new Intent(getApplicationContext(),NavBarActivity.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            /*startActivity(new Intent(ViewJobStatusNavBar.this,ApplyForJobsNavBar.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(ViewJobStatusNavBar.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(ViewJobStatusNavBar.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(ViewJobStatusNavBar.this,UpdateDetailsNavBar.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(ViewJobStatusNavBar.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(ViewJobStatusNavBar.this,ChangePasswordNavBar.class);
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
