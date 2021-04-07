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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


import java.util.List;

public class ManageStudentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emailIdFromOtherClass;
    private String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_student);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        ScrollView mscrollView = (ScrollView) findViewById(R.id.manage_student_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.stduent_id);

        DatabaseHelper helper = new DatabaseHelper(ManageStudentActivity.this);

        List<StudentContact> studentList = helper.getAllStudent();

        for(int i=0; i<studentList.size();i++)
        {
            final StudentContact c = studentList.get(i);
            TextView textView = new TextView(ManageStudentActivity.this);
            textView.setTextSize(20);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            textView.setGravity(Gravity.CENTER);
            textView.setText("\n * * * * * *  Student Index No: "+(i+1)+"  * * * * * * * \n");
            linearLayout.addView(textView);

            TextView textView0 = new TextView(ManageStudentActivity.this);
            textView0.setTextSize(18);
            textView0.setText(" Student Name: "+c.getName());
            textView0.setTextColor(Color.parseColor("#000000"));
            textView0.setTypeface(Typeface.SANS_SERIF);
            linearLayout.addView(textView0);

            TextView textView1 = new TextView(ManageStudentActivity.this);
            textView1.setTextSize(18);
            textView1.setTextColor(Color.parseColor("#000000"));
            textView1.setTypeface(Typeface.SANS_SERIF);
            textView1.setText(" Student UserName: "+c.getUname());
            linearLayout.addView(textView1);

            TextView textView2 = new TextView(ManageStudentActivity.this);
            textView2.setTextSize(18);
            textView2.setTextColor(Color.parseColor("#000000"));
            textView2.setTypeface(Typeface.SANS_SERIF);
            textView2.setText(" Student Id: "+c.getUid());
            linearLayout.addView(textView2);

            TextView textView3 = new TextView(ManageStudentActivity.this);
            textView3.setTextSize(18);
            textView3.setTextColor(Color.parseColor("#000000"));
            textView3.setTypeface(Typeface.SANS_SERIF);
            textView3.setText(" Student EmailId: "+c.getEmailId());
            linearLayout.addView(textView3);

            TextView textView4 = new TextView(ManageStudentActivity.this);
            textView4.setTextSize(18);
            textView4.setTextColor(Color.parseColor("#000000"));
            textView4.setTypeface(Typeface.SANS_SERIF);
            textView4.setText(" Student ContactNo: "+c.getContactNo());
            linearLayout.addView(textView4);

            TextView textView5 = new TextView(ManageStudentActivity.this);
            textView5.setTextSize(18);
            textView5.setTextColor(Color.parseColor("#000000"));
            textView5.setTypeface(Typeface.SANS_SERIF);
            textView5.setText(" Student Address: "+c.getAddress());
            linearLayout.addView(textView5);

            TextView textView6 = new TextView(ManageStudentActivity.this);
            textView6.setTextSize(18);
            textView6.setTextColor(Color.parseColor("#000000"));
            textView6.setTypeface(Typeface.SANS_SERIF);
            textView6.setText(" Student SSC Marks: "+c.getSsc());
            linearLayout.addView(textView6);

            TextView textView7 = new TextView(ManageStudentActivity.this);
            textView7.setTextSize(18);
            textView7.setTextColor(Color.parseColor("#000000"));
            textView7.setTypeface(Typeface.SANS_SERIF);
            textView7.setText(" Student HSC Marks: "+c.getHsc());
            linearLayout.addView(textView7);

            if(c.getGrade()!=null)
            {
                TextView textView8 = new TextView(ManageStudentActivity.this);
                textView8.setTextSize(18);
                textView8.setTextColor(Color.parseColor("#000000"));
                textView8.setTypeface(Typeface.SANS_SERIF);
                textView8.setText(" Student Grade: "+c.getGrade());
                linearLayout.addView(textView8);

                TextView textView9 = new TextView(ManageStudentActivity.this);
                textView9.setTextSize(18);
                textView9.setTextColor(Color.parseColor("#000000"));
                textView9.setTypeface(Typeface.SANS_SERIF);
                textView9.setText(" Student Skills: "+c.getSkill());
                linearLayout.addView(textView9);

                TextView textViewh = new TextView(ManageStudentActivity.this);
                textViewh.setTextSize(18);
                textViewh.setTextColor(Color.parseColor("#000000"));
                textViewh.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                textViewh.setGravity(Gravity.CENTER);
                textViewh.setText("\n * * * * * * * * *  Applied Jobs * * * * * * * * * \n");
                linearLayout.addView(textViewh);


                TextView textViewa = new TextView(ManageStudentActivity.this);
                textViewa.setTextSize(16);
                textViewa.setTextColor(Color.parseColor("#000000"));
                textViewa.setTypeface(Typeface.SANS_SERIF);
                textViewa.setText("\n Student CompanyName: "+c.getCompanyName1());
                linearLayout.addView(textViewa);

                TextView textViewb = new TextView(ManageStudentActivity.this);
                textViewb.setTextSize(16);
                textViewb.setTextColor(Color.parseColor("#000000"));
                textViewb.setTypeface(Typeface.SANS_SERIF);
                textViewb.setText(" Student CompanyEmail: "+c.getCompanyEmail1());
                linearLayout.addView(textViewb);

                TextView textViewc = new TextView(ManageStudentActivity.this);
                textViewc.setTextSize(16);
                textViewc.setTextColor(Color.parseColor("#000000"));
                textViewc.setTypeface(Typeface.SANS_SERIF);
                textViewc.setText(" Student JobName: "+c.getJobName1());
                linearLayout.addView(textViewc);

                TextView textViewd = new TextView(ManageStudentActivity.this);
                textViewd.setTextSize(16);
                textViewd.setTextColor(Color.parseColor("#000000"));
                textViewd.setTypeface(Typeface.SANS_SERIF);
                textViewd.setText(" Student JobId: "+c.getJobId1());
                linearLayout.addView(textViewd);

                TextView textViewe = new TextView(ManageStudentActivity.this);
                textViewe.setTextSize(16);
                textViewe.setTextColor(Color.parseColor("#000000"));
                textViewe.setTypeface(Typeface.SANS_SERIF);
                textViewe.setText(" Student JobType: "+c.getJobType1()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textViewe);

                if(c.getCompanyName2()!=null)
                {
                    TextView textViewa1 = new TextView(ManageStudentActivity.this);
                    textViewa1.setTextSize(16);
                    textViewa1.setTextColor(Color.parseColor("#000000"));
                    textViewa1.setTypeface(Typeface.SANS_SERIF);
                    textViewa1.setText(" CompanyName: "+c.getCompanyName2());
                    linearLayout.addView(textViewa1);

                    TextView textViewb1 = new TextView(ManageStudentActivity.this);
                    textViewb1.setTextSize(16);
                    textViewb1.setTextColor(Color.parseColor("#000000"));
                    textViewb1.setTypeface(Typeface.SANS_SERIF);
                    textViewb1.setText(" CompanyEmail: "+c.getCompanyEmail2());
                    linearLayout.addView(textViewb1);

                    TextView textViewc1 = new TextView(ManageStudentActivity.this);
                    textViewc1.setTextSize(16);
                    textViewc1.setTextColor(Color.parseColor("#000000"));
                    textViewc1.setTypeface(Typeface.SANS_SERIF);
                    textViewc1.setText(" JobName: "+c.getJobName2());
                    linearLayout.addView(textViewc1);

                    TextView textViewd1 = new TextView(ManageStudentActivity.this);
                    textViewd1.setTextSize(16);
                    textViewd1.setTextColor(Color.parseColor("#000000"));
                    textViewd1.setTypeface(Typeface.SANS_SERIF);
                    textViewd1.setText(" JobId: "+c.getJobId2());
                    linearLayout.addView(textViewd1);

                    TextView textViewe1 = new TextView(ManageStudentActivity.this);
                    textViewe1.setTextSize(16);
                    textViewe1.setTextColor(Color.parseColor("#000000"));
                    textViewe1.setTypeface(Typeface.SANS_SERIF);
                    textViewe1.setText(" JobType: "+c.getJobType2()+"\n-------------------------------------------------------------\n");
                    linearLayout.addView(textViewe1);

                    if(c.getCompanyName3()!=null)
                    {
                        TextView textViewa3 = new TextView(ManageStudentActivity.this);
                        textViewa3.setTextSize(16);
                        textViewa3.setTextColor(Color.parseColor("#000000"));
                        textViewa3.setTypeface(Typeface.SANS_SERIF);
                        textViewa3.setText(" CompanyName: "+c.getCompanyName3());
                        linearLayout.addView(textViewa3);

                        TextView textViewb3 = new TextView(ManageStudentActivity.this);
                        textViewb3.setTextSize(16);
                        textViewb3.setTextColor(Color.parseColor("#000000"));
                        textViewb3.setTypeface(Typeface.SANS_SERIF);
                        textViewb3.setText(" CompanyEmail: "+c.getCompanyEmail3());
                        linearLayout.addView(textViewb3);

                        TextView textViewc3 = new TextView(ManageStudentActivity.this);
                        textViewc3.setTextSize(16);
                        textViewc3.setTextColor(Color.parseColor("#000000"));
                        textViewc3.setTypeface(Typeface.SANS_SERIF);
                        textViewc3.setText(" JobName: "+c.getJobName3());
                        linearLayout.addView(textViewc3);

                        TextView textViewd3 = new TextView(ManageStudentActivity.this);
                        textViewd3.setTextSize(16);
                        textViewd3.setText(" JobId: "+c.getJobId3());
                        textViewd3.setTextColor(Color.parseColor("#000000"));
                        textViewd3.setTypeface(Typeface.SANS_SERIF);
                        linearLayout.addView(textViewd3);

                        TextView textViewe3 = new TextView(ManageStudentActivity.this);
                        textViewe3.setTextSize(16);
                        textViewe3.setTextColor(Color.parseColor("#000000"));
                        textViewe3.setTypeface(Typeface.SANS_SERIF);
                        textViewe3.setText(" JobType: "+c.getJobType3()+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textViewe3);

                        if(c.getCompanyName4()!=null)
                        {
                            TextView textViewa4 = new TextView(ManageStudentActivity.this);
                            textViewa4.setTextSize(16);
                            textViewa4.setTextColor(Color.parseColor("#000000"));
                            textViewa4.setTypeface(Typeface.SANS_SERIF);
                            textViewa4.setText(" CompanyName: "+c.getCompanyName4());
                            linearLayout.addView(textViewa4);

                            TextView textViewb4 = new TextView(ManageStudentActivity.this);
                            textViewb4.setTextSize(16);
                            textViewb4.setTextColor(Color.parseColor("#000000"));
                            textViewb4.setTypeface(Typeface.SANS_SERIF);
                            textViewb4.setText(" CompanyEmail: "+c.getCompanyEmail4());
                            linearLayout.addView(textViewb4);

                            TextView textViewc4 = new TextView(ManageStudentActivity.this);
                            textViewc4.setTextSize(16);
                            textViewc4.setTextColor(Color.parseColor("#000000"));
                            textViewc4.setTypeface(Typeface.SANS_SERIF);
                            textViewc4.setText(" JobName: "+c.getJobName4());
                            linearLayout.addView(textViewc4);

                            TextView textViewd4 = new TextView(ManageStudentActivity.this);
                            textViewd4.setTextSize(16);
                            textViewd4.setTextColor(Color.parseColor("#000000"));
                            textViewd4.setTypeface(Typeface.SANS_SERIF);
                            textViewd4.setText(" JobId: "+c.getJobId4());
                            linearLayout.addView(textViewd4);

                            TextView textViewe4 = new TextView(ManageStudentActivity.this);
                            textViewe4.setTextSize(16);
                            textViewe4.setTextColor(Color.parseColor("#000000"));
                            textViewe4.setTypeface(Typeface.SANS_SERIF);
                            textViewe4.setText(" JobType: "+c.getJobType4()+"\n-------------------------------------------------------------\n");
                            linearLayout.addView(textViewe4);

                        }
                    }

                }
            }
            LinearLayout row = new LinearLayout(this);
            row.setLayoutParams(new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));
            row.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout.addView(row);

            Button btn1 = new Button(this);
            btn1.setText("Update");
            btn1.setBackgroundColor(Color.parseColor("#000000"));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(200,0,75,50);
            btn1.setTextColor(Color.parseColor("#ffffff"));
            btn1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            btn1.setLayoutParams(params);
            row.addView(btn1);
            final String x=c.getEmailId();

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ManageStudentActivity.this, Student_update_details_by_admin.class);
                    i.putExtra("Email", x);
                    i.putExtra("EmailId",emailIdFromOtherClass);
                    i.putExtra("Name",name);
                    startActivity(i);
                    finish();
                }
            });

            Button btn2 = new Button(this);
            btn2.setText("Delete");
            btn2.setBackgroundColor(Color.parseColor("#000000"));
            LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params1.setMargins(75,0,0,50);
            btn2.setTextColor(Color.parseColor("#ffffff"));
            btn2.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            btn2.setLayoutParams(params1);
            row.addView(btn2);

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ManageStudentActivity.this, delete_student_by_admin.class);
                    i.putExtra("Email", x);
                    i.putExtra("EmailId",emailIdFromOtherClass);
                    i.putExtra("Name",name);
                    startActivity(i);
                    finish();
                }
            });
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
        getMenuInflater().inflate(R.menu.manage_student, menu);
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
  //          mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), loginAdmin.class));
            finish();
            return true;
        }

        else if(id==R.id.help)
        {
            startActivity(new Intent(getApplicationContext(),adminHelp.class));
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
        if(id==R.id.admin_home){
            Intent i = new Intent(ManageStudentActivity.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //        startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(ManageStudentActivity.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //  startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(ManageStudentActivity.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(ManageStudentActivity.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(ManageStudentActivity.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
