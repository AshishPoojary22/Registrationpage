package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    EditText Name, Email, Date;
    Button Submit;
    Databasehelper userDB;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userDB = new Databasehelper(this);
        Date = (EditText) findViewById(R.id.button);
        Name = (EditText) findViewById(R.id.editText);
        Email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Submit = (Button) findViewById(R.id.submit_area);
        AddData();
        Date.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                picker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth)
                    {
                        Date.setText(dayofmonth + "/" + (month + 1) + "/" + year );

                    }
                }, year, month, day);
                picker.show();
            }
        });
    }






    public void AddData(){
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String email = Email.getText().toString();
                String dob = Date.getText().toString();

                boolean insertData = userDB.addData(name, email, dob);
                if (insertData=true){
                    Toast.makeText(MainActivity.this, "Data transfered successfully!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Oopps, Something went wrong", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Username", name);
                intent.putExtra("Birthdate", dob);
                intent.putExtra("mail", email);

                startActivity(intent);

            }
        });


    }
}