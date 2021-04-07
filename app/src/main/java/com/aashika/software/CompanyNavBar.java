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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class CompanyNavBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
   private String emailIdFromOtherClass;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");

        DatabaseHelperCompany helper = new DatabaseHelperCompany(CompanyNavBar.this);
        ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        name=list.get(1);
        TextView hi = (TextView) findViewById(R.id.hi_company);
        hi.setTextColor(Color.parseColor("#000000"));
        hi.setTypeface(Typeface.SANS_SERIF);
        String justTry = " * * * * * * * * My Information * * * * * * * *\n\n"+" Company Name: " + list.get(1)+ "\n Company Id: " + list.get(3)+ "\n Rank: " + list.get(8)+ "\n Email Id: " + list.get(4)+ "\n Contact No: " + list.get(5)+ "\n Address: " + list.get(7);
        //view.setText("hello crp");
        hi.setTextSize(18);
        hi.setText(justTry);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"admin@gmail.com"});
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Issues caused");
                intent.putExtra(Intent.EXTRA_TEXT , "Hello Admin, \n\n Here is the issues I have faced Kindly check the issue as soon as possible! \n\n Thank you.");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
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
        getMenuInflater().inflate(R.menu.company_nav_bar, menu);
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
            // Handle the camera action
            /*startActivity(new Intent(getApplicationContext(),PostJobs.class));*/
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
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class));*/
            Intent i = new Intent(getApplicationContext(),ViewStudentApplicationCompanyNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_manage) {
/*
            startActivity(new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
*/
            Intent i = new Intent(getApplicationContext(),CompanyUpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(getApplicationContext(),CompanyChangePasswordNavBar.class));*/
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
