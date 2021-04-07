package com.aashika.software;

        import android.content.Intent;
        import android.os.Bundle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.view.GravityCompat;
        import androidx.drawerlayout.widget.DrawerLayout;

        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ScrollView;

        import java.util.ArrayList;

public class delete_company_by_admin extends AppCompatActivity {
    private String emailIdFromOtherClass;
    private String email;
    private String name;
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
        setContentView(R.layout.delete_company_by_admin);
        ScrollView mscrollView = (ScrollView) findViewById(R.id.company_update_details_scroll_id);
        mfullName = (EditText) findViewById(R.id.updateNameCompany);
        mUserId = (EditText) findViewById(R.id.updateUserIdCompany);
        mRank = (EditText) findViewById(R.id.update_rank_id_company);
        mEmailId = (EditText) findViewById(R.id.updateEmailIdCompany);
        mContactNo = (EditText) findViewById(R.id.updateContactNoCompany);
        mAddress = (EditText) findViewById(R.id.updateAddressCompany);
        mButton = (Button) findViewById(R.id.update_company_profile_id);
        email = getIntent().getExtras().getString("Email");
        emailIdFromOtherClass = getIntent().getExtras().getString("EmailId");
        name = getIntent().getExtras().getString("Name");
        DatabaseHelperCompany helper = new DatabaseHelperCompany(delete_company_by_admin.this);
        final ArrayList<String> list = helper.searchEmail(email);
        mfullName.setText(list.get(1));
        mUserId.setText(list.get(3));
        Log.v("email", list.get(4));
        mEmailId.setText(list.get(4));
        mContactNo.setText(list.get(5));
        mAddress.setText(list.get(7));
        mRank.setText(list.get(8));

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mfullName.getText().toString().isEmpty()) {
                    mfullName.requestFocus();
                    mfullName.setError("Company Name is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mUserId.getText().toString().isEmpty()) {
                    mUserId.requestFocus();
                    mUserId.setError("Company Id is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mRank.getText().toString().isEmpty()) {
                    mRank.requestFocus();
                    mRank.setError("Rank is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mEmailId.getText().toString().isEmpty()) {
                    mEmailId.requestFocus();
                    mEmailId.setError("Email Id is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mContactNo.getText().toString().isEmpty()) {
                    mContactNo.requestFocus();
                    mContactNo.setError("Contact No is required");
                    return;
                }
                Log.v("tag", "hi");
                if (mAddress.getText().toString().isEmpty()) {
                    mAddress.requestFocus();
                    mAddress.setError("Address is required");
                    return;
                }
                Log.v("tag", "hi");

                //childRef.setValue(mfullName);
                if (mfullName.getText().toString().isEmpty() || mUserId.getText().toString().isEmpty() || mRank.getText().toString().isEmpty() || mEmailId.getText().toString().isEmpty() || mContactNo.getText().toString().isEmpty() || mAddress.getText().toString().isEmpty()) {
                    return;
                } else {
                    DatabaseHelperCompany helper = new DatabaseHelperCompany(delete_company_by_admin.this);
                    CompanyContact c = new CompanyContact();
                    c.setId(Integer.parseInt(list.get(0)));
                    helper.delete(c);
                    Intent i = new Intent(delete_company_by_admin.this, ManageCompany.class);
                    i.putExtra("EmailId",emailIdFromOtherClass);
                    i.putExtra("Name",name);
                    startActivity(i);
                    finish();

                }

            }
        });


    }

}
