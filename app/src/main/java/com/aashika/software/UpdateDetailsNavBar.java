package com.aashika.software;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class UpdateDetailsNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String emailIdFromOtherClass;
    private EditText mfullName;
    private EditText mUsername;
    private EditText mUserId;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private EditText mSSC;
    private EditText mHSC;
    private Button mButton;
    private Button IButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;
    private String mhint6;
    private String mhint7;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_details_nav_bar);

        /*code for spinner*/

        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.department_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner mspinner = (Spinner) findViewById(R.id.year_id);
        ArrayAdapter<CharSequence> madapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(madapter);

        Spinner nspinner = (Spinner) findViewById(R.id.year1_id);
        ArrayAdapter<CharSequence> nadapter = ArrayAdapter.createFromResource(UpdateDetailsNavBar.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
        nadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nspinner.setAdapter(nadapter);

        ScrollView mscrollView = (ScrollView) findViewById(R.id.update_details_scroll_id);
        mfullName = (EditText) findViewById(R.id.updateName);
        mUsername = (EditText) findViewById(R.id.updateUsername);
        mUserId = (EditText) findViewById(R.id.updateUserId);
        mEmailId = (EditText) findViewById(R.id.updateEmailId);
        mContactNo = (EditText) findViewById(R.id.updateContactNo);
        mAddress = (EditText) findViewById(R.id.updateAddress);
        mSSC = (EditText) findViewById(R.id.updateSSC);
        mHSC = (EditText) findViewById(R.id.updateHSC);

        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        Log.v("email",emailIdFromOtherClass);
        DatabaseHelper helper = new DatabaseHelper(UpdateDetailsNavBar.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        StudentContact c = new StudentContact();
        c.setId(Integer.parseInt(list.get(0)));
        name=list.get(1);
        mfullName.setText(list.get(1));
        mUsername.setText(list.get(2));
        mUserId.setText(list.get(3));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
        mSSC.setText(list.get(8));
        mHSC.setText(list.get(9));
        mButton = (Button) findViewById(R.id.update_profile_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  User user = new User(mfullName.getText().toString(),mUsername.getText().toString(),mUserId.getText().toString(),mEmailId.getText().toString(),mContactNo.getText().toString(),mAddress.getText().toString(),mSSC.getText().toString(),mHSC.getText().toString());
                //  userRef = rootRef.child(mAuth.getCurrentUser().getUid()).child("Profile");
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Full Name is required");
                    return;
                }

                if(mUsername.getText().toString().isEmpty())
                {
                    mUsername.requestFocus();
                    mUsername.setError("Username is required");
                    return;
                }

                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("User Id is required");
                    return;
                }

                if(mEmailId.getText().toString().isEmpty())
                {
                    mEmailId.requestFocus();
                    mEmailId.setError("Email Id is required");
                    return;
                }

                if(mContactNo.getText().toString().isEmpty())
                {
                    mContactNo.requestFocus();
                    mContactNo.setError("Contact No is required");
                    return;
                }

                if(mAddress.getText().toString().isEmpty())
                {
                    mAddress.requestFocus();
                    mAddress.setError("Address is required");
                    return;
                }

                if(mSSC.getText().toString().isEmpty())
                {
                    mSSC.requestFocus();
                    mSSC.setError("SSC is required");
                    return;
                }

                if(mHSC.getText().toString().isEmpty())
                {
                    mHSC.requestFocus();
                    mHSC.setError("HSC is required");
                    return;
                }

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUsername.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() || mSSC.getText().toString().isEmpty() || mHSC.getText().toString().isEmpty())
                {
                    return;
                }
                else
                {
                    DatabaseHelper helper = new DatabaseHelper(UpdateDetailsNavBar.this);
                    StudentContact c = new StudentContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(mfullName.getText().toString());
                    c.setUname(mUsername.getText().toString());
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    String password = helper.searchPassword(mEmailId.getText().toString());
                    c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                    c.setSsc(mSSC.getText().toString());
                    c.setHsc(mHSC.getText().toString());
                    helper.updateProfile(c);
                    Intent i = new Intent(UpdateDetailsNavBar.this,NavBarActivity.class);
                    i.putExtra("EmailId",mEmailId.getText().toString());
                    startActivity(i);
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
        getMenuInflater().inflate(R.menu.update_details_nav_bar, menu);
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
            startActivity(new Intent(UpdateDetailsNavBar.this, login.class));
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
            /*startActivity(new Intent(getApplicationContext(),NavBarActivity.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;*/
            Intent i = new Intent(UpdateDetailsNavBar.this,NavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ApplyForJobsNavBar.class));*/
            //finish();
            Intent i = new Intent(UpdateDetailsNavBar.this,ApplyForJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ViewJobStatusNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,ViewJobStatusNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,SearchJobsNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,SearchJobsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_manage) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,UpdateDetailsNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,UpdateDetailsNavBar.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            drawer.closeDrawer(GravityCompat.START);
            return true;

        } else if (id == R.id.nav_password) {
            /*startActivity(new Intent(UpdateDetailsNavBar.this,ChangePasswordNavBar.class));*/
            Intent i = new Intent(UpdateDetailsNavBar.this,ChangePasswordNavBar.class);
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
