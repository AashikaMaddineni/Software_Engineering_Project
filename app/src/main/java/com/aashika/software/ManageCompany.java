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

public class ManageCompany extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
     TextView text;
    private String name;
    private String emailIdFromOtherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_company);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        ScrollView mscrollView = (ScrollView) findViewById(R.id.manage_company_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.company_id);

        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(ManageCompany.this);
        List<CompanyContact> companyList = helperCompany.getAllCompany();

        for(int i=0; i<companyList.size();i++)
        {
            CompanyContact c = companyList.get(i);
            TextView textView = new TextView(ManageCompany.this);
            textView.setTextSize(18);
            textView.setTextColor(Color.parseColor("#000000"));
            textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
            textView.setGravity(Gravity.CENTER);
            textView.setText("  * * * * * * * *  Company Index No: "+(i+1)+" * * * * * * * * \n");
            linearLayout.addView(textView);

            TextView textView0 = new TextView(ManageCompany.this);
            textView0.setTextSize(18);
            textView0.setTextColor(Color.parseColor("#000000"));
            textView0.setText(" Company Name: "+c.getName());
            linearLayout.addView(textView0);

            TextView textView1 = new TextView(ManageCompany.this);
            textView1.setTextSize(18);
            textView1.setTextColor(Color.parseColor("#000000"));
            textView1.setText(" Company UserName: "+c.getUname());
            linearLayout.addView(textView1);

            TextView textView2 = new TextView(ManageCompany.this);
            textView2.setTextSize(18);
            textView2.setTextColor(Color.parseColor("#000000"));
            textView2.setText(" Company Id: "+c.getUid());
            linearLayout.addView(textView2);

            TextView textView3 = new TextView(ManageCompany.this);
            textView3.setTextSize(18);
            textView3.setTextColor(Color.parseColor("#000000"));
            textView3.setText(" Company EmailId: "+c.getEmailId());
            linearLayout.addView(textView3);

            TextView textView4 = new TextView(ManageCompany.this);
            textView4.setTextSize(18);
            textView4.setTextColor(Color.parseColor("#000000"));
            textView4.setText(" Company ContactNo: "+c.getContactNo());
            linearLayout.addView(textView4);

            TextView textView5 = new TextView(ManageCompany.this);
            textView5.setTextSize(18);
            textView5.setTextColor(Color.parseColor("#000000"));
            textView5.setText(" Company Address: "+c.getAddress());
            linearLayout.addView(textView5);

            TextView textView6 = new TextView(ManageCompany.this);
            textView6.setTextSize(18);
            textView6.setTextColor(Color.parseColor("#000000"));
            textView6.setText(" Company Rank: "+c.getRank() +"\n=====================================\n");
            linearLayout.addView(textView6);



            if(c.getJobName1()!=null)
            {

                TextView textViewjob = new TextView(ManageCompany.this);
                textViewjob.setText("Jobs Posted\n");
                textViewjob.setGravity(Gravity.CENTER);
                textViewjob.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                textViewjob.setTextColor(Color.parseColor("#000000"));
                textViewjob.setTextSize(18);
                linearLayout.addView(textViewjob);

                TextView textViewc = new TextView(ManageCompany.this);
                textViewc.setText(" Company JobName:"+c.getJobName1());
                textViewc.setTextColor(Color.parseColor("#000000"));
                textViewc.setTextSize(16);
                linearLayout.addView(textViewc);

                TextView textViewd = new TextView(ManageCompany.this);
                textViewd.setTextSize(16);
                textViewd.setTextColor(Color.parseColor("#000000"));
                textViewd.setText(" Company JobId: "+c.getJobId1());
                linearLayout.addView(textViewd);

                TextView textViewe = new TextView(ManageCompany.this);
                textViewe.setTextSize(16);
                textViewe.setTextColor(Color.parseColor("#000000"));
                textViewe.setText(" Company JobType: "+c.getJobType1());
                linearLayout.addView(textViewe);

                TextView textViewf = new TextView(ManageCompany.this);
                textViewf.setTextSize(16);
                textViewf.setTextColor(Color.parseColor("#000000"));
                textViewf.setText(" Company JobSalary: "+c.getSalary1()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textViewf);

                if(c.getJobName2()!=null)
                {
                    TextView textViewc1 = new TextView(ManageCompany.this);
                    textViewc1.setTextSize(16);
                    textViewc1.setTextColor(Color.parseColor("#000000"));
                    textViewc1.setText(" Company JobName: "+c.getJobName2());
                    linearLayout.addView(textViewc1);

                    TextView textViewd1 = new TextView(ManageCompany.this);
                    textViewd1.setTextSize(16);
                    textViewd1.setTextColor(Color.parseColor("#000000"));
                    textViewd1.setText(" Company JobId: "+c.getJobId2());
                    linearLayout.addView(textViewd1);

                    TextView textViewe1 = new TextView(ManageCompany.this);
                    textViewe1.setTextSize(16);
                    textViewe1.setTextColor(Color.parseColor("#000000"));
                    textViewe1.setText(" Company JobType: "+c.getJobType2());
                    linearLayout.addView(textViewe1);

                    TextView textViewf1 = new TextView(ManageCompany.this);
                    textViewf1.setTextSize(16);
                    textViewf1.setTextColor(Color.parseColor("#000000"));
                    textViewf1.setText(" Company JobSalary: "+c.getSalary2()+"\n-------------------------------------------------------------\n");
                    linearLayout.addView(textViewf1);

                    if(c.getJobName3()!=null)
                    {
                        TextView textViewc3 = new TextView(ManageCompany.this);
                        textViewc3.setTextSize(16);
                        textViewc3.setTextColor(Color.parseColor("#000000"));
                        textViewc3.setText(" Company JobName: "+c.getJobName3());
                        linearLayout.addView(textViewc3);

                        TextView textViewd3 = new TextView(ManageCompany.this);
                        textViewd3.setTextSize(16);
                        textViewd3.setTextColor(Color.parseColor("#000000"));
                        textViewd3.setText(" Company JobId: "+c.getJobId3());
                        linearLayout.addView(textViewd3);

                        TextView textViewe3 = new TextView(ManageCompany.this);
                        textViewe3.setTextSize(16);
                        textViewe3.setTextColor(Color.parseColor("#000000"));
                        textViewe3.setText(" Company JobType: "+c.getJobType3());
                        linearLayout.addView(textViewe3);

                        TextView textViewf3 = new TextView(ManageCompany.this);
                        textViewf3.setTextSize(16);
                        textViewf3.setTextColor(Color.parseColor("#000000"));
                        textViewf3.setText(" Company JobSalary: "+c.getSalary3()+"\n-------------------------------------------------------------\n");
                        linearLayout.addView(textViewf3);
                        if(c.getJobName4()!=null)
                        {
                            TextView textViewc4 = new TextView(ManageCompany.this);
                            textViewc4.setTextSize(16);
                            textViewc4.setTextColor(Color.parseColor("#000000"));
                            textViewc4.setText(" Company JobName: "+c.getJobName4());
                            linearLayout.addView(textViewc4);

                            TextView textViewd4 = new TextView(ManageCompany.this);
                            textViewd4.setTextSize(16);
                            textViewd4.setTextColor(Color.parseColor("#000000"));
                            textViewd4.setText(" Company JobId: "+c.getJobId4());
                            linearLayout.addView(textViewd4);

                            TextView textViewe4 = new TextView(ManageCompany.this);
                            textViewe4.setTextSize(16);
                            textViewe4.setTextColor(Color.parseColor("#000000"));
                            textViewe4.setText(" Company JobType: "+c.getJobType4());
                            linearLayout.addView(textViewe4);

                            TextView textViewf4 = new TextView(ManageCompany.this);
                            textViewf4.setTextSize(16);
                            textViewf4.setTextColor(Color.parseColor("#000000"));
                            textViewf4.setText(" Company JobSalary: "+c.getSalary4()+"\n-------------------------------------------------------------\n");
                            linearLayout.addView(textViewf4);
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
                    Intent i = new Intent(ManageCompany.this, Company_update_details_by_admin.class);
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
                    Intent i = new Intent(ManageCompany.this, delete_company_by_admin.class);
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
        getMenuInflater().inflate(R.menu.manage_company, menu);
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
    //        mAuth.signOut();
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
            Intent i = new Intent(ManageCompany.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            // startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(ManageCompany.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            // startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(ManageCompany.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(ManageCompany.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(ManageCompany.this,AdminChangePasswordNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            // /startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
