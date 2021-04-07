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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class CompanyUpdateDetailsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String name;
    private String emailIdFromOtherClass;
    private EditText mfullName;
    private EditText mUserId;
    private EditText mRank;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private Button mButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_update_details_nav_bar);
        ScrollView mscrollView = (ScrollView) findViewById(R.id.company_update_details_scroll_id);
        mfullName = (EditText) findViewById(R.id.updateNameCompany);
        mUserId = (EditText) findViewById(R.id.updateUserIdCompany);
        mRank = (EditText) findViewById(R.id.update_rank_id_company);
        mEmailId = (EditText) findViewById(R.id.updateEmailIdCompany);
        mContactNo = (EditText) findViewById(R.id.updateContactNoCompany);
        mAddress = (EditText) findViewById(R.id.updateAddressCompany);
        mButton = (Button) findViewById(R.id.update_company_profile_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        Log.v("email",emailIdFromOtherClass);
        DatabaseHelperCompany helper = new DatabaseHelperCompany(CompanyUpdateDetailsNavBar.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        mfullName.setText(list.get(1));
        mUserId.setText(list.get(3));
        Log.v("email",list.get(4));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
        mRank.setText(list.get(8));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  User user = new User(mfullName.getText().toString(),mUsername.getText().toString(),mUserId.getText().toString(),mEmailId.getText().toString(),mContactNo.getText().toString(),mAddress.getText().toString(),mSSC.getText().toString(),mHSC.getText().toString());
//                userRef = rootRef.child(mAuth.getCurrentUser().getUid()).child("Profile");
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Company Name is required");
                    return;
                }
                Log.v("tag","hi");
                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("Company Id is required");
                    return;
                }
                Log.v("tag","hi");
                if(mRank.getText().toString().isEmpty())
                {
                    mRank.requestFocus();
                    mRank.setError("Rank is required");
                    return;
                }
                Log.v("tag","hi");
                if(mEmailId.getText().toString().isEmpty())
                {
                    mEmailId.requestFocus();
                    mEmailId.setError("Email Id is required");
                    return;
                }
                Log.v("tag","hi");
                if(mContactNo.getText().toString().isEmpty())
                {
                    mContactNo.requestFocus();
                    mContactNo.setError("Contact No is required");
                    return;
                }
                Log.v("tag","hi");
                if(mAddress.getText().toString().isEmpty())
                {
                    mAddress.requestFocus();
                    mAddress.setError("Address is required");
                    return;
                }
                Log.v("tag","hi");

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mRank.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() )
                {
                    return;
                }
                else
                {
                    DatabaseHelperCompany helper = new DatabaseHelperCompany(CompanyUpdateDetailsNavBar.this);
                    CompanyContact c = new CompanyContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(mfullName.getText().toString());
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    String password = helper.searchPassword(mEmailId.getText().toString());
                    c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                    c.setRank(mRank.getText().toString());
                    helper.updateCompanyProfile(c);
                    Intent i = new Intent(CompanyUpdateDetailsNavBar.this,CompanyNavBar.class);
                    i.putExtra("EmailId",mEmailId.getText().toString());
                    startActivity(i);
                    //startActivity(new Intent(CompanyUpdateDetailsNavBar.this,CompanyNavBar.class));
                    finish();
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
        getMenuInflater().inflate(R.menu.company_update_details_nav_bar, menu);
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
            Intent i = new Intent(getApplicationContext(),PostJobs.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
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
        }

        else if (id == R.id.nav_gallery) {
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
