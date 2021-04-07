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
import android.widget.Toast;
import java.util.List;

public class CompanyView_Posted_Jobs extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String name;
    private String emailIdFromOtherClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_view_posted_jobs);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");

        ScrollView mscrollView = (ScrollView) findViewById(R.id.manage_company_scroll_id);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.company_id);

        DatabaseHelperCompany helperCompany = new DatabaseHelperCompany(CompanyView_Posted_Jobs.this);
        List<CompanyContact> companyList = helperCompany.getAllCompany();
        for(int i=0; i<companyList.size();i++)
        {
            CompanyContact c = companyList.get(i);
                if (c.getEmailId().equals(emailIdFromOtherClass)) {

                    if(c.getJobName1()!=null) {
                        TextView textViewjob = new TextView(CompanyView_Posted_Jobs.this);
                        textViewjob.setText("Jobs Posted\n");
                        textViewjob.setGravity(Gravity.CENTER);
                        textViewjob.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                        textViewjob.setTextColor(Color.parseColor("#000000"));
                        textViewjob.setTextSize(22);
                        linearLayout.addView(textViewjob);

                        TextView textViewc = new TextView(CompanyView_Posted_Jobs.this);
                        textViewc.setText(" Company JobName:" + c.getJobName1());
                        textViewc.setTextColor(Color.parseColor("#000000"));
                        textViewc.setTextSize(16);
                        linearLayout.addView(textViewc);

                        TextView textViewd = new TextView(CompanyView_Posted_Jobs.this);
                        textViewd.setTextSize(16);
                        textViewd.setTextColor(Color.parseColor("#000000"));
                        textViewd.setText(" Company JobId: " + c.getJobId1());
                        linearLayout.addView(textViewd);

                        TextView textViewe = new TextView(CompanyView_Posted_Jobs.this);
                        textViewe.setTextSize(16);
                        textViewe.setTextColor(Color.parseColor("#000000"));
                        textViewe.setText(" Company JobType: " + c.getJobType1());
                        linearLayout.addView(textViewe);

                        TextView textViewf = new TextView(CompanyView_Posted_Jobs.this);
                        textViewf.setTextSize(16);
                        textViewf.setTextColor(Color.parseColor("#000000"));
                        textViewf.setText(" Company JobSalary: " + c.getSalary1() + "\n-------------------------------------------------------------\n");
                        linearLayout.addView(textViewf);

                        LinearLayout row = new LinearLayout(this);
                        row.setLayoutParams(new LinearLayout.LayoutParams
                                (LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT));
                        row.setOrientation(LinearLayout.HORIZONTAL);
                        linearLayout.addView(row);

                        Button update = new Button(this);
                        update.setBackgroundColor(Color.parseColor("#000000"));
                        update.setText("UPDATE");
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        params.setMargins(200, 0, 75, 50);
                        update.setTextColor(Color.parseColor("#ffffff"));
                        update.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                        update.setLayoutParams(params);

                        row.addView(update);
                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_updation.class);
                                i.putExtra("EmailId", emailIdFromOtherClass);
                                i.putExtra("Name", name);
                                i.putExtra("Id", 1);
                                Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                startActivity(i);
                            }
                        });


                        Button delete = new Button(this);
                        delete.setBackgroundColor(Color.parseColor("#000000"));
                        delete.setText("DELETE");
                        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        params1.setMargins(75, 0, 0, 50);
                        delete.setTextColor(Color.parseColor("#ffffff"));
                        delete.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                        delete.setLayoutParams(params1);
                        row.addView(delete);
                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_deletion.class);
                                i.putExtra("EmailId", emailIdFromOtherClass);
                                i.putExtra("Name", name);
                                i.putExtra("Id", 1);
                                Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                startActivity(i);
                            }
                        });

                    }

                        if(c.getJobName2()!=null) {
                            TextView textViewc1 = new TextView(CompanyView_Posted_Jobs.this);
                            textViewc1.setTextSize(16);
                            textViewc1.setTextColor(Color.parseColor("#000000"));
                            textViewc1.setText(" Company JobName: " + c.getJobName2());
                            linearLayout.addView(textViewc1);

                            TextView textViewd1 = new TextView(CompanyView_Posted_Jobs.this);
                            textViewd1.setTextSize(16);
                            textViewd1.setTextColor(Color.parseColor("#000000"));
                            textViewd1.setText(" Company JobId: " + c.getJobId2());
                            linearLayout.addView(textViewd1);

                            TextView textViewe1 = new TextView(CompanyView_Posted_Jobs.this);
                            textViewe1.setTextSize(16);
                            textViewe1.setTextColor(Color.parseColor("#000000"));
                            textViewe1.setText(" Company JobType: " + c.getJobType2());
                            linearLayout.addView(textViewe1);

                            TextView textViewf1 = new TextView(CompanyView_Posted_Jobs.this);
                            textViewf1.setTextSize(16);
                            textViewf1.setTextColor(Color.parseColor("#000000"));
                            textViewf1.setText(" Company JobSalary: " + c.getSalary2() + "\n-------------------------------------------------------------\n");
                            linearLayout.addView(textViewf1);


                            LinearLayout rowa = new LinearLayout(this);
                            rowa.setLayoutParams(new LinearLayout.LayoutParams
                                    (LinearLayout.LayoutParams.MATCH_PARENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT));
                            rowa.setOrientation(LinearLayout.HORIZONTAL);
                            linearLayout.addView(rowa);

                            Button updatea = new Button(this);
                            updatea.setBackgroundColor(Color.parseColor("#000000"));
                            updatea.setText("UPDATE");
                            LinearLayout.LayoutParams paramsa = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                            );
                            paramsa.setMargins(200, 0, 75, 50);
                            updatea.setTextColor(Color.parseColor("#ffffff"));
                            updatea.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                            updatea.setLayoutParams(paramsa);

                            rowa.addView(updatea);
                            updatea.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_updation.class);
                                    i.putExtra("EmailId", emailIdFromOtherClass);
                                    i.putExtra("Name", name);
                                    i.putExtra("Id", 2);
                                    Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                    startActivity(i);
                                }
                            });


                            Button deletea = new Button(this);
                            deletea.setBackgroundColor(Color.parseColor("#000000"));
                            deletea.setText("DELETE");
                            LinearLayout.LayoutParams paramsa1 = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.WRAP_CONTENT,
                                    LinearLayout.LayoutParams.WRAP_CONTENT
                            );
                            paramsa1.setMargins(75, 0, 0, 50);
                            deletea.setTextColor(Color.parseColor("#ffffff"));
                            deletea.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                            deletea.setLayoutParams(paramsa1);
                            rowa.addView(deletea);
                            deletea.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_deletion.class);
                                    i.putExtra("EmailId", emailIdFromOtherClass);
                                    i.putExtra("Name", name);
                                    i.putExtra("Id", 2);
                                    Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                    startActivity(i);
                                }
                            });
                        }

                            if(c.getJobName3()!=null) {
                                TextView textViewc3 = new TextView(CompanyView_Posted_Jobs.this);
                                textViewc3.setTextSize(16);
                                textViewc3.setTextColor(Color.parseColor("#000000"));
                                textViewc3.setText(" Company JobName: " + c.getJobName3());
                                linearLayout.addView(textViewc3);

                                TextView textViewd3 = new TextView(CompanyView_Posted_Jobs.this);
                                textViewd3.setTextSize(16);
                                textViewd3.setTextColor(Color.parseColor("#000000"));
                                textViewd3.setText(" Company JobId: " + c.getJobId3());
                                linearLayout.addView(textViewd3);

                                TextView textViewe3 = new TextView(CompanyView_Posted_Jobs.this);
                                textViewe3.setTextSize(16);
                                textViewe3.setTextColor(Color.parseColor("#000000"));
                                textViewe3.setText(" Company JobType: " + c.getJobType3());
                                linearLayout.addView(textViewe3);

                                TextView textViewf3 = new TextView(CompanyView_Posted_Jobs.this);
                                textViewf3.setTextSize(16);
                                textViewf3.setTextColor(Color.parseColor("#000000"));
                                textViewf3.setText(" Company JobSalary: " + c.getSalary3() + "\n-------------------------------------------------------------\n");
                                linearLayout.addView(textViewf3);

                                LinearLayout rowb = new LinearLayout(this);
                                rowb.setLayoutParams(new LinearLayout.LayoutParams
                                        (LinearLayout.LayoutParams.MATCH_PARENT,
                                                LinearLayout.LayoutParams.WRAP_CONTENT));
                                rowb.setOrientation(LinearLayout.HORIZONTAL);
                                linearLayout.addView(rowb);

                                Button updateb = new Button(this);
                                updateb.setBackgroundColor(Color.parseColor("#000000"));
                                updateb.setText("UPDATE");
                                LinearLayout.LayoutParams paramsb = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                );
                                paramsb.setMargins(200, 0, 75, 50);
                                updateb.setTextColor(Color.parseColor("#ffffff"));
                                updateb.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                updateb.setLayoutParams(paramsb);

                                rowb.addView(updateb);
                                updateb.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_updation.class);
                                        i.putExtra("EmailId", emailIdFromOtherClass);
                                        i.putExtra("Name", name);
                                        i.putExtra("Id", 3);
                                        Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                        startActivity(i);
                                    }
                                });


                                Button deleteb = new Button(this);
                                deleteb.setBackgroundColor(Color.parseColor("#000000"));
                                deleteb.setText("DELETE");
                                LinearLayout.LayoutParams paramsb1 = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                );
                                paramsb1.setMargins(75, 0, 0, 50);
                                deleteb.setTextColor(Color.parseColor("#ffffff"));
                                deleteb.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                deleteb.setLayoutParams(paramsb1);
                                rowb.addView(deleteb);
                                deleteb.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_deletion.class);
                                        i.putExtra("EmailId", emailIdFromOtherClass);
                                        i.putExtra("Name", name);
                                        i.putExtra("Id", 3);
                                        Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                        startActivity(i);
                                    }
                                });

                            }
                                if(c.getJobName4()!=null)
                                {
                                    TextView textViewc4 = new TextView(CompanyView_Posted_Jobs.this);
                                    textViewc4.setTextSize(16);
                                    textViewc4.setTextColor(Color.parseColor("#000000"));
                                    textViewc4.setText(" Company JobName: "+c.getJobName4());
                                    linearLayout.addView(textViewc4);

                                    TextView textViewd4 = new TextView(CompanyView_Posted_Jobs.this);
                                    textViewd4.setTextSize(16);
                                    textViewd4.setTextColor(Color.parseColor("#000000"));
                                    textViewd4.setText(" Company JobId: "+c.getJobId4());
                                    linearLayout.addView(textViewd4);

                                    TextView textViewe4 = new TextView(CompanyView_Posted_Jobs.this);
                                    textViewe4.setTextSize(16);
                                    textViewe4.setTextColor(Color.parseColor("#000000"));
                                    textViewe4.setText(" Company JobType: "+c.getJobType4());
                                    linearLayout.addView(textViewe4);

                                    TextView textViewf4 = new TextView(CompanyView_Posted_Jobs.this);
                                    textViewf4.setTextSize(16);
                                    textViewf4.setTextColor(Color.parseColor("#000000"));
                                    textViewf4.setText(" Company JobSalary: "+c.getSalary4()+"\n-------------------------------------------------------------\n");
                                    linearLayout.addView(textViewf4);


                                    LinearLayout rowc = new LinearLayout(this);
                                    rowc.setLayoutParams(new LinearLayout.LayoutParams
                                            (LinearLayout.LayoutParams.MATCH_PARENT,
                                                    LinearLayout.LayoutParams.WRAP_CONTENT));
                                    rowc.setOrientation(LinearLayout.HORIZONTAL);
                                    linearLayout.addView(rowc);

                                    Button updatec= new Button(this);
                                    updatec.setBackgroundColor(Color.parseColor("#000000"));
                                    updatec.setText("UPDATE");
                                    LinearLayout.LayoutParams paramsc = new LinearLayout.LayoutParams(
                                            LinearLayout.LayoutParams.WRAP_CONTENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT
                                    );
                                    paramsc.setMargins(200,0,75,50);
                                    updatec.setTextColor(Color.parseColor("#ffffff"));
                                    updatec.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                    updatec.setLayoutParams(paramsc);

                                    rowc.addView(updatec);
                                    updatec.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_updation.class);
                                            i.putExtra("EmailId", emailIdFromOtherClass);
                                            i.putExtra("Name", name);
                                            i.putExtra("Id", 4);
                                            Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                            startActivity(i);
                                           }
                                    });


                                    Button deletec = new Button(this);
                                    deletec.setBackgroundColor(Color.parseColor("#000000"));
                                    deletec.setText("DELETE");
                                    LinearLayout.LayoutParams paramsc1 = new LinearLayout.LayoutParams(
                                            LinearLayout.LayoutParams.WRAP_CONTENT,
                                            LinearLayout.LayoutParams.WRAP_CONTENT
                                    );
                                    paramsc1.setMargins(75,0,0,50);
                                    deletec.setTextColor(Color.parseColor("#ffffff"));
                                    deletec.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                                    deletec.setLayoutParams(paramsc1);
                                    rowc.addView(deletec);
                                    deletec.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent i = new Intent(CompanyView_Posted_Jobs.this, company_posted_jobs_deletion.class);
                                            i.putExtra("EmailId", emailIdFromOtherClass);
                                            i.putExtra("Name", name);
                                            i.putExtra("Id", 4);
                                            Toast.makeText(getApplicationContext(), "Check details of posted Jobs", Toast.LENGTH_LONG).show();
                                            startActivity(i);
                                        }
                                    });



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
        getMenuInflater().inflate(R.menu.companyview_posted_jobs, menu);
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
            // mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
            /*startActivity(new Intent(getApplicationContext(),CompanyNavBar.class));*/
            Intent i = new Intent(getApplicationContext(),CompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // startActivity(new Intent(getApplicationContext(),PostJobs.class));
            //finish();
            Intent i = new Intent(getApplicationContext(), PostJobs.class);
            i.putExtra("EmailId", emailIdFromOtherClass);
            i.putExtra("Name", name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
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
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));
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

        } */else if (id == R.id.nav_manage) {
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
