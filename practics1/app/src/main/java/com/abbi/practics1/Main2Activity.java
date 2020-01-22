package com.abbi.practics1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    TextView name;
    TextView email;
    private static final String mypreference = "mypref";
    private static final String Name = "nameKey";
    private static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
    }
    public void Save(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();

        Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show();
    }

    public void clear(View view) {
        name = findViewById(R.id.etName);
        email =findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");

        Toast.makeText(this,"CLEARED",Toast.LENGTH_SHORT).show();
    }

    public void Get(View view) {
        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmail);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)) {
            name.setText(sharedpreferences.getString(Name, ""));
        }
        if (sharedpreferences.contains(Email)) {
            email.setText(sharedpreferences.getString(Email, ""));
        }
        Toast.makeText(this,"GET DATA FROM SHARED ",Toast.LENGTH_SHORT).show();
    }
}
