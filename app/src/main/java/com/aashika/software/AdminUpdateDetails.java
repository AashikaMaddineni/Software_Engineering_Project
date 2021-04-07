package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AdminUpdateDetails extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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
    private String emailIdFromOtherClass;
    private String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_details);


        ScrollView mscrollView = (ScrollView) findViewById(R.id.update_admin_details_scroll_id);

        mfullName = (EditText) findViewById(R.id.AdminFullName);
        mUserId = (EditText) findViewById(R.id.AdminId);

        mEmailId = (EditText) findViewById(R.id.AdminEmailId);
        mContactNo = (EditText) findViewById(R.id.AdminContactNo);
        mAddress = (EditText) findViewById(R.id.AdminAddress);
        mButton = (Button) findViewById(R.id.update_admin_profile_id);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        Log.v("email",emailIdFromOtherClass);
        DatabaseHelperAdmin helper = new DatabaseHelperAdmin(AdminUpdateDetails.this);
        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);
        mfullName.setText(list.get(1));
        /*mUsername.setText(list.get(2));*/
        mUserId.setText(list.get(3));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
      /*  mSSC.setText(list.get(8));
        mHSC.setText(list.get(9));
*/
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //userRef = rootRef.child(mAuth.getCurrentUser().getUid());
                if(mfullName.getText().toString().isEmpty())
                {
                    mfullName.requestFocus();
                    mfullName.setError("Admin Name is required");
                    return;
                }
                if(mUserId.getText().toString().isEmpty())
                {
                    mUserId.requestFocus();
                    mUserId.setError("Admin Id is required");
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

                //childRef.setValue(mfullName);
                if(mfullName.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty() )
                {
                    return;
                }
                else
                {
                    /*userRef.child("Admin Name").setValue(mfullName.getText().toString());
                    userRef.child("Admin Id").setValue(mUserId.getText().toString());
                    userRef.child("Email Id").setValue(mEmailId.getText().toString());
                    userRef.child("Contact No").setValue(mContactNo.getText().toString());
                    userRef.child("Address").setValue(mAddress.getText().toString());*/
                    DatabaseHelperAdmin helperAdmin = new DatabaseHelperAdmin(AdminUpdateDetails.this);
                    AdminContact c = new AdminContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    c.setName(mfullName.getText().toString());
                   /* c.setUname(mUsername.getText().toString());*/
                    c.setUid(mUserId.getText().toString());
                    c.setEmailId(mEmailId.getText().toString());
                    c.setContactNo(mContactNo.getText().toString());
                    //String password = helper.searchPassword(mEmailId.getText().toString());
                   // c.setPassword(password);
                    c.setAddress(mAddress.getText().toString());
                   // c.setSsc(mSSC.getText().toString());
                    //c.setHsc(mHSC.getText().toString());
                    helperAdmin.updateProfile(c);
                    Intent i = new Intent(AdminUpdateDetails.this,AdminNavBarActivity.class);
                    i.putExtra("EmailId",mEmailId.getText().toString());
                    startActivity(i);
                    finish();
//                    startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
                   // finish();
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
        getMenuInflater().inflate(R.menu.admin_update_details, menu);
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
          //  mAuth.signOut();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
            Intent i = new Intent(AdminUpdateDetails.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            //startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(AdminUpdateDetails.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            //startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            Intent i = new Intent(AdminUpdateDetails.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            Intent i = new Intent(AdminUpdateDetails.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            //startActivity(new Intent(getApplicationContext(),AdminChangePasswordNavBar.class));
            Intent i = new Intent(AdminUpdateDetails.this,AdminChangePasswordNavBar.class);
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
