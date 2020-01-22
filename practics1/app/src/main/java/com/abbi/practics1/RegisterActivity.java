package com.abbi.practics1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.abbi.practics1.Database.DBOperations;
import com.abbi.practics1.Database.Properties;

public class RegisterActivity extends AppCompatActivity {


    EditText firstnames;
    EditText lastnames;
    EditText emails;
    EditText passwords;
    EditText confirmpasswords;
    EditText addresss;
    EditText phonenumbers;
    Button   signups;
    CheckBox checkBoxs;

    String firstname="";
    String lastname="";
    String email="";
    String password="";
    String confirmpassword="";
    String address="";
    String phonenumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firstnames = findViewById(R.id.editText_firstname);
        lastnames = findViewById(R.id.editText_lastname);
        emails = findViewById(R.id.editText_email);
        passwords = findViewById(R.id.editText_password);
        confirmpasswords =findViewById(R.id.editText_confirmpassword);
        addresss = findViewById(R.id.editText_address);
        phonenumbers = findViewById(R.id.editText_phonenumber);
        signups = findViewById(R.id.button_register);
        checkBoxs = findViewById(R.id.checkBox_tc);
    }

    public void onSubmit (View v) {
        firstname = firstnames.getText().toString();
        lastname = lastnames.getText().toString();
        email = emails.getText().toString();
        password = passwords.getText().toString();
        confirmpassword = confirmpasswords.getText().toString();
        address = addresss.getText().toString();
        phonenumber = phonenumbers.getText().toString();

        boolean isError = false;
        if (firstname != null && firstname.equalsIgnoreCase("")) {
            firstnames.setError("Please enter valid First Name");
            isError = true;
        }
        if (lastname != null && lastname.equalsIgnoreCase("")) {
            lastnames.setError("Please enter valid last name");
            isError = true;
        }
        if (email != null && email.equalsIgnoreCase("")) {
            emails.setError("Please enter valid email");
            isError = true;
        }
        if (password != null && password.equalsIgnoreCase("")) {
            passwords.setError("Please enter valid password");
        }
        if (confirmpassword != null && confirmpassword.equalsIgnoreCase("")) {
            confirmpasswords.setError("Please enter valid confirm password");
            isError = true;
        }
        if (address != null && address.equalsIgnoreCase("")) {
            addresss.setError("Please enter valid address");
            isError = true;
        }
        if (phonenumber != null && phonenumber.equalsIgnoreCase("")) {
            phonenumbers.setError("Please enter valid phonenumber");
            isError = true;
        }
        if (!checkBoxs.isChecked()) {
            checkBoxs.setTextColor(Color.RED);
        }
        if (!isError) {
            if (saveData() != 0) {
                Toast.makeText(this, "Sucessfull", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "SOME THING WENT WRONG", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private Properties getProperties()
    {
        Properties pro = new Properties();
        pro.setFirstName(firstname);
        pro.setLastName(lastname);
        pro.setEmail(email);
        pro.setPassword(password);
        pro.setAddress(address);
        pro.setPhonenumber(phonenumber);
        return pro;
    }
    private long saveData()
    {
        DBOperations db = new DBOperations();
        return db.writeUserinDB(getProperties());
    }
}
