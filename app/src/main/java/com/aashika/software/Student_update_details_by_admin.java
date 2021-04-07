package com.aashika.software;

        import android.content.Intent;
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
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ScrollView;
        import android.widget.Spinner;

        import java.util.ArrayList;

public class Student_update_details_by_admin extends AppCompatActivity {

    private String emailIdFromOtherClass;
    private String email;
    private String name;
    private EditText mfullName;
    private EditText mUsername;
    private EditText mUserId;
    private EditText mEmailId;
    private EditText mContactNo;
    private EditText mAddress;
    private EditText mSSC;
    private EditText mHSC;
    private Button mButton;
    private String mhint;
    private String mhint1;
    private String mhint2;
    private String mhint3;
    private String mhint4;
    private String mhint5;
    private String mhint6;
    private String mhint7;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_update_details_by_admin);

        /*code for spinner*/

        Spinner spinner = (Spinner) findViewById(R.id.department_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Student_update_details_by_admin.this, R.array.department_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner mspinner = (Spinner) findViewById(R.id.year_id);
        ArrayAdapter<CharSequence> madapter = ArrayAdapter.createFromResource(Student_update_details_by_admin.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
        madapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mspinner.setAdapter(madapter);

        Spinner nspinner = (Spinner) findViewById(R.id.year1_id);
        ArrayAdapter<CharSequence> nadapter = ArrayAdapter.createFromResource(Student_update_details_by_admin.this, R.array.year_spinner, android.R.layout.simple_spinner_item);
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
        email = getIntent().getExtras().getString("Email");
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        DatabaseHelper helper = new DatabaseHelper(Student_update_details_by_admin.this);
        final ArrayList<String> list = helper.searchEmail(email);
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
                    DatabaseHelper helper = new DatabaseHelper(Student_update_details_by_admin.this);
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
                    Intent i = new Intent(Student_update_details_by_admin.this,ManageStudentActivity.class);
                    i.putExtra("EmailId",emailIdFromOtherClass);
                    i.putExtra("Name",name);
                    startActivity(i);
                    finish();
                }

            }
        });

    }
}
