package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
//import androidx.recyclerview.R;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    TextView name, dob, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        name = (TextView) findViewById(R.id.Name);
        dob = (TextView) findViewById(R.id.Bday);
        email = (TextView) findViewById(R.id.mail);


        String username = getIntent().getStringExtra("Username");
        String Bday = getIntent().getStringExtra("Birthdate");
        String Email = getIntent().getStringExtra("mail");

        name.setText(username);
        dob.setTag(Bday);
        email.setTag(Email);





    }
}