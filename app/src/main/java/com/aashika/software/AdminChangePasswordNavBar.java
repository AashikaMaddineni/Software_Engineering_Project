package com.aashika.software;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class AdminChangePasswordNavBar extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private EditText mnewPassword;
    private EditText moldPassword;
    private EditText mConfirmPassword;
    private String emailIdFromOtherClass;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_change_password_nav_bar);
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
       // mAuth = FirebaseAuth.getInstance();
        ScrollView mscrollView = (ScrollView) findViewById(R.id.admin_change_password_scroll_id);

        moldPassword = (EditText) findViewById(R.id.old_password_id);
        mnewPassword = (EditText) findViewById(R.id.new_password_id);
        mConfirmPassword = (EditText) findViewById(R.id.new_confirm_password_id);
        Button mSubmit = (Button) findViewById(R.id.submit_button_id);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(moldPassword.getText().toString().isEmpty())
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("Password is required");
                    return;
                }
                if(moldPassword.getText().toString().length()<6)
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("Password length must be minimum 6");
                    return;
                }
                DatabaseHelperAdmin helper = new DatabaseHelperAdmin(AdminChangePasswordNavBar.this);
                String password1 = helper.searchPassword(emailIdFromOtherClass);
                if((password1.equals(moldPassword.getText().toString())))
                {
                    if(mnewPassword.getText().toString().isEmpty())
                    {
                        mnewPassword.requestFocus();
                        mnewPassword.setError("Password is required");
                        return;
                    }
                    if(mnewPassword.getText().toString().length()<6)
                    {
                        mnewPassword.requestFocus();
                        mnewPassword.setError("Password length must be minimum 6");
                        return;
                    }

                    if(mConfirmPassword.getText().toString().isEmpty())
                    {
                        mConfirmPassword.requestFocus();
                        mConfirmPassword.setError("Password is required");
                        return;
                    }
                    if(mConfirmPassword.getText().toString().length()<6)
                    {
                        mConfirmPassword.requestFocus();
                        mConfirmPassword.setError("Password length must be minimum 6");
                        return;
                    }
                    if(mnewPassword.getText().toString().equals(mConfirmPassword.getText().toString()))
                    {
                        final ArrayList<String> list = helper.searchEmail(emailIdFromOtherClass);

                        AdminContact c = new AdminContact();
                        c.setId(Integer.parseInt(list.get(0)));
                        c.setName(list.get(1));
                        c.setUname(list.get(2));
                        c.setUid(list.get(3));
                        c.setEmailId(list.get(4));
                        c.setContactNo(list.get(5));
                        c.setPassword(list.get(6));
                        c.setAddress(list.get(7));
                        helper.changePassword(mnewPassword.getText().toString(),emailIdFromOtherClass,c);
                        Intent i = new Intent(AdminChangePasswordNavBar.this,loginAdmin.class);
                        i.putExtra("EmailId",emailIdFromOtherClass);
                        Toast.makeText(getApplicationContext(),"Password changed successfully",Toast.LENGTH_LONG).show();
                        startActivity(i);

                    /*mUser = FirebaseAuth.getInstance().getCurrentUser();
                    mUser.updatePassword(mnewPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Password Updated",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(getApplicationContext(),loginAdmin.class));
                                finish();
                            }
                            else
                            {
                                String errorMessage = task.getException().getMessage();
                                Toast.makeText(getApplicationContext(),"Try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });*/
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"New Password & new COnfirm password didn't match",Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                else
                {
                    moldPassword.requestFocus();
                    moldPassword.setError("oldPassword is wrong Try Again!");
                    return;

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
        getMenuInflater().inflate(R.menu.admin_change_password_nav_bar, menu);
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
         //   mAuth.signOut();
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
           // startActivity(new Intent(getApplicationContext(),AdminNavBarActivity.class));
            Intent i = new Intent(AdminChangePasswordNavBar.this,AdminNavBarActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        else if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent i = new Intent(AdminChangePasswordNavBar.this,ManageStudentActivity.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),ManageStudentActivity.class));
            //finish();
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent(AdminChangePasswordNavBar.this,ManageCompany.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),ManageCompany.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent i = new Intent(AdminChangePasswordNavBar.this,AdminUpdateDetails.class);
            i.putExtra("EmailId",emailIdFromOtherClass);
            i.putExtra("Name",name);
            startActivity(i);
            //startActivity(new Intent(getApplicationContext(),AdminUpdateDetails.class));
            drawer.closeDrawer(GravityCompat.START);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent i = new Intent(AdminChangePasswordNavBar.this,AdminChangePasswordNavBar.class);
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
