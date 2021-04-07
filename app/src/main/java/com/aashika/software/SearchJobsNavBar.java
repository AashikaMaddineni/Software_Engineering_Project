package com.aashika.software;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchJobsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emailIdFromOtherClass;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_jobs_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        DatabaseHelper helper = new DatabaseHelper(SearchJobsNavBar.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        name=list.get(1);

        ScrollView mscrollView = (ScrollView) findViewById(R.id.search_jobs_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.search_jobs_layout_id);

        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(SearchJobsNavBar.this);
        List<CompanyContact> companyList = helperCompany.getAllCompany();

        for(int i=0; i<companyList.size();i++)
        {
            CompanyContact c = companyList.get(i);
            if(c.getJobName1()!=null)
            {
                TextView textView = new TextView(SearchJobsNavBar.this);
                textView.setTextSize(18);
                textView.setText("  * * * * * * * * * * * * Jobs Posted * * * * * * * * * *  \n");
                textView.setTextColor(Color.parseColor("#000000"));
                textView.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                linearLayout.addView(textView);

                TextView textView0 = new TextView(SearchJobsNavBar.this);
                textView0.setTextSize(16);
                textView0.setText(" Job Title: "+c.getJobName1());
                textView0.setTextColor(Color.parseColor("#000000"));
                linearLayout.addView(textView0);

                TextView textView1 = new TextView(SearchJobsNavBar.this);
                textView1.setTextSize(16);
                textView1.setTextColor(Color.parseColor("#000000"));
                textView1.setText(" Company Name: "+c.getName());
                linearLayout.addView(textView1);


                TextView textView2 = new TextView(SearchJobsNavBar.this);
                textView2.setTextSize(16);
                textView2.setTextColor(Color.parseColor("#000000"));
                textView2.setText(" Job Id: "+c.getJobId1());
                linearLayout.addView(textView2);

                TextView textView3 = new TextView(SearchJobsNavBar.this);
                textView3.setTextSize(16);
                textView3.setTextColor(Color.parseColor("#000000"));
                textView3.setText(" Job Type: "+c.getJobType1());
                linearLayout.addView(textView3);

                TextView textView4 = new TextView(SearchJobsNavBar.this);
                textView4.setTextSize(16);
                textView4.setTextColor(Color.parseColor("#000000"));
                textView4.setText(" Salary: "+c.getSalary1()+"\n-----------------------------------------------------------------------------------------\n");
                linearLayout.addView(textView4);


                Button btn1 = new Button(this);
                btn1.setText("Apply");
                btn1.setBackgroundColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(400,0,0,50);
                btn1.setTextColor(Color.parseColor("#ffffff"));
                btn1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                btn1.setLayoutParams(params);
                linearLayout.addView(btn1);
                String Cemail=c.getEmailId();
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            if (list.get(14)!=null) {
                                btn1.setText("Applied");
                            }
                        else {
                            Intent i = new Intent(SearchJobsNavBar.this, apply_jobs_from_search.class);
                            i.putExtra("EmailId", emailIdFromOtherClass);
                            i.putExtra("Name", name);
                            i.putExtra("Cemail", Cemail);
                            i.putExtra("flag", 1);
                            startActivity(i);
                            finish();
                        }

                    }
                });
            }

            if(c.getJobName2()!=null)
            {
                TextView textView5 = new TextView(SearchJobsNavBar.this);
                textView5.setTextSize(16);
                textView5.setText(" Job Title: "+c.getJobName2());
                textView5.setTextColor(Color.parseColor("#000000"));
                linearLayout.addView(textView5);

                TextView textView6 = new TextView(SearchJobsNavBar.this);
                textView6.setTextSize(16);
                textView6.setTextColor(Color.parseColor("#000000"));
                textView6.setText(" Company Name: "+c.getName());
                linearLayout.addView(textView6);

                TextView textView7 = new TextView(SearchJobsNavBar.this);
                textView7.setTextSize(16);
                textView7.setTextColor(Color.parseColor("#000000"));
                textView7.setText(" Job Id: "+c.getJobId2());
                linearLayout.addView(textView7);

                TextView textView8 = new TextView(SearchJobsNavBar.this);
                textView8.setTextSize(16);
                textView8.setTextColor(Color.parseColor("#000000"));
                textView8.setText(" Job Type: "+c.getJobType2());
                linearLayout.addView(textView8);

                TextView textView9 = new TextView(SearchJobsNavBar.this);
                textView9.setTextSize(16);
                textView9.setTextColor(Color.parseColor("#000000"));
                textView9.setText(" Salary: "+c.getSalary2()+"\n----------------------------------------------------------------------------------------\n");
                linearLayout.addView(textView9);


                Button btn1 = new Button(this);
                btn1.setText("Apply");
                btn1.setBackgroundColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                params.setMargins(400,0,0,50);
                btn1.setTextColor(Color.parseColor("#ffffff"));
                btn1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                btn1.setLayoutParams(params);
                linearLayout.addView(btn1);
                String Cemail=c.getEmailId();
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (list.get(20)!=null) {
                            btn1.setText("Applied");
                        } else {
                            Intent i = new Intent(SearchJobsNavBar.this, apply_jobs_from_search.class);
                            i.putExtra("EmailId", emailIdFromOtherClass);
                            i.putExtra("Name", name);
                            i.putExtra("Cemail", Cemail);
                            i.putExtra("flag", 2);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }
            if(c.getJobName3()!=null)
            {
                TextView textView10 = new TextView(SearchJobsNavBar.this);
                textView10.setTextSize(16);
                textView10.setTextColor(Color.parseColor("#000000"));
                textView10.setText(" Job Title: "+c.getJobName3());
                linearLayout.addView(textView10);

                TextView textView11 = new TextView(SearchJobsNavBar.this);
                textView11.setTextSize(16);
                textView11.setTextColor(Color.parseColor("#000000"));
                textView11.setText(" Company Name: "+c.getName());
                linearLayout.addView(textView11);

                TextView textView12 = new TextView(SearchJobsNavBar.this);
                textView12.setTextSize(16);
                textView12.setTextColor(Color.parseColor("#000000"));
                textView12.setText(" Job Id: "+c.getJobId3());
                linearLayout.addView(textView12);

                TextView textView13 = new TextView(SearchJobsNavBar.this);
                textView13.setTextSize(16);
                textView13.setTextColor(Color.parseColor("#000000"));
                textView13.setText(" Job Type: "+c.getJobType3());
                linearLayout.addView(textView13);

                TextView textView14 = new TextView(SearchJobsNavBar.this);
                textView14.setTextSize(16);
                textView14.setTextColor(Color.parseColor("#000000"));
                textView14.setText(" Salary: "+c.getSalary3()+"\n------------------------------------------------------------------------------------\n");
                linearLayout.addView(textView14);


                Button btn1 = new Button(this);
                btn1.setText("Apply");
                btn1.setBackgroundColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(400,0,0,50);
                btn1.setTextColor(Color.parseColor("#ffffff"));
                btn1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                btn1.setLayoutParams(params);
                linearLayout.addView(btn1);
                String Cemail=c.getEmailId();
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (list.get(26)!=null) {
                            btn1.setText("Applied");
                        }
                        else {
                            Intent i = new Intent(SearchJobsNavBar.this, apply_jobs_from_search.class);
                            i.putExtra("EmailId", emailIdFromOtherClass);
                            i.putExtra("Name", name);
                            i.putExtra("Cemail", Cemail);
                            i.putExtra("flag", 3);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }

            if(c.getJobName4()!=null)
            {
                TextView textView15 = new TextView(SearchJobsNavBar.this);
                textView15.setTextSize(16);
                textView15.setTextColor(Color.parseColor("#000000"));
                textView15.setText(" Job Title: "+c.getJobName4());
                linearLayout.addView(textView15);

                TextView textView16 = new TextView(SearchJobsNavBar.this);
                textView16.setTextSize(16);
                textView16.setTextColor(Color.parseColor("#000000"));
                textView16.setText(" Company Name: "+c.getName());
                linearLayout.addView(textView16);

                TextView textView17 = new TextView(SearchJobsNavBar.this);
                textView17.setTextSize(16);
                textView17.setText(" Job Id: "+c.getJobId4());
                textView17.setTextColor(Color.parseColor("#000000"));
                linearLayout.addView(textView17);

                TextView textView18 = new TextView(SearchJobsNavBar.this);
                textView18.setTextSize(16);
                textView18.setTextColor(Color.parseColor("#000000"));
                textView18.setText(" Job Type: "+c.getJobType4());
                linearLayout.addView(textView18);

                TextView textView19 = new TextView(SearchJobsNavBar.this);
                textView19.setTextSize(16);
                textView19.setTextColor(Color.parseColor("#000000"));
                textView19.setText(" Salary: "+c.getSalary4()+"\n-------------------------------------------------------------\n");
                linearLayout.addView(textView19);


                Button btn1 = new Button(this);
                btn1.setText("Apply");
                btn1.setBackgroundColor(Color.parseColor("#000000"));
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(400,0,0,50);
                btn1.setTextColor(Color.parseColor("#ffffff"));
                btn1.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                btn1.setLayoutParams(params);
                linearLayout.addView(btn1);
                String Cemail=c.getEmailId();
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(SearchJobsNavBar.this, apply_jobs_from_search.class);
                        if (list.get(34)!=null) {
                            btn1.setText("Applied");
                        }
                        else {
                            i.putExtra("EmailId", emailIdFromOtherClass);
                            i.putExtra("Name", name);
                            i.putExtra("Cemail", Cemail);
                            i.putExtra("flag", 4);
                            startActivity(i);
                            finish();
                        }
                    }
                });
            }


        }

        /*MyListAdapter adapter = new MyListAdapter(getApplicationContext(), maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list_item);
        list.setAdapter(adapter);
*/
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
        getMenuInflater().inflate(R.menu.search_jobs_nav_bar, menu);
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
        //    mAuth.signOut();
            startActivity(new Intent(SearchJobsNavBar.this, login.class));
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
            Intent i = new Intent(SearchJobsNavBar.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ApplyForJobsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(SearchJobsNavBar.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(SearchJobsNavBar.this,UpdateDetailsNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(SearchJobsNavBar.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(SearchJobsNavBar.this,ChangePasswordNavBar.class);
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
