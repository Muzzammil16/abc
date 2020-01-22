package com.abbi.practics1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.TextView;

import com.abbi.practics1.Database.DBOperations;
import com.abbi.practics1.Database.Properties;


public class  MainActivity extends AppCompatActivity {

    EditText email;
    EditText password;

    Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editText_email);
        password = findViewById(R.id.editText_password);

    }

    public void onClickSubmitButton(View v) {
        String emailtxt = email.getText().toString();
        String pass = password.getText().toString();
        boolean isError = false;
        if (emailtxt != null && emailtxt.equalsIgnoreCase("")) {
            email.setError("Please enter Valid name");
            isError = true;
        }
        if (pass != null && pass.equalsIgnoreCase("")) {
            password.setError("Please enter Valid name");
            isError = true;
        }
        if (!isError) {
            Intent intent = new Intent(this, Main2Activity.class);
            intent.putExtra("NAME", emailtxt);
            startActivity(intent);
        }

    }

    private Properties getProperties(String email) {
        DBOperations db = new DBOperations();
        return db.getPropertiesInformation(email);
    }
}



