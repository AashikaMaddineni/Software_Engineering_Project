package com.aashika.software;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.util.ArrayList;

public class NavBarActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
   private String emailIdFromOtherClass;
   private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_bar);
          SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(NavBarActivity.this);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.d("hello","hi");
        Log.d("hello",emailIdFromOtherClass);
        DatabaseHelper helper = new DatabaseHelper(NavBarActivity.this);
        ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        Log.v("hi",list.get(1));
        name=list.get(1);
        TextView hi = (TextView) findViewById(R.id.hi);
        String justTry = " * * * * * * * * * * * My Information * * * * * * * * * *\n\n"+" Full Name: " + list.get(1)+ "\n UserName: " + list.get(2)+ "\n User Id: " + list.get(3)+ "\n Email Id: " + list.get(4)+ "\n Contact No: " + list.get(5)+ "\n Address: " + list.get(7)+ "\n HSC: " + list.get(8)+ "\n SSC: " + list.get(9);
        //view.setText("hello crp");
        hi.setTypeface(Typeface.SANS_SERIF);
        hi.setTextSize(18);
        hi.setText(justTry);
        hi.setTextColor(Color.parseColor("#000000"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

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
        getMenuInflater().inflate(R.menu.nav_bar, menu);
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
            startActivity(new Intent(NavBarActivity.this, MainActivity.class));
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
            Intent i = new Intent(NavBarActivity.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            /*startActivity(new Intent(NavBarActivity.this,ApplyForJobsNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(NavBarActivity.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(NavBarActivity.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(NavBarActivity.this,UpdateDetailsNavBar.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;*/
            Intent i = new Intent(NavBarActivity.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(NavBarActivity.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(NavBarActivity.this,ChangePasswordNavBar.class);
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
