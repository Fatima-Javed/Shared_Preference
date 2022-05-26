package com.example.my_shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity
{
    TextView username,t_email;
    Button logout;

    SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME="my_pref";
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        username=(TextView) findViewById(R.id.textView3);
        t_email=(TextView) findViewById(R.id.textView5);
        logout=(Button) findViewById(R.id.btnLogOut);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        String name=sharedPreferences.getString(KEY_NAME,null);
        String email=sharedPreferences.getString(KEY_EMAIL,null);

        if(email!=null || name!=null)
        {
            username.setText(name);
            t_email.setText(email);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(RegisterActivity.this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }


}