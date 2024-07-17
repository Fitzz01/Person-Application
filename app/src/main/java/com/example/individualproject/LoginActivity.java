package com.example.individualproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText name, password, conPass, Phone;
    Button signUpBtn;
    TextView AHA;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        name      = findViewById(R.id.UserName);
        password  = findViewById(R.id.password);
        conPass   = findViewById(R.id.repassword);
        Phone     = findViewById(R.id.phone);
        AHA       = findViewById(R.id.alreadyAccount);
        signUpBtn = findViewById(R.id.SignUpBtn);

        db        = new DBHelper(this);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username   = name.getText().toString();
                String pass       = password.getText().toString();
                String cPassword  = conPass.getText().toString();
                String phone      = Phone.getText().toString();

                if(username.equals("") || pass.equals("") || cPassword.equals("") || phone.equals(""))
                    Toast.makeText(LoginActivity.this, "Enter All Requirement", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(cPassword)){
                        boolean checkUser = db.checkUser(phone);
                        if(checkUser == false){
                            boolean insert = db.insertData(username, pass, phone);
                            if(insert == true){
                                Toast.makeText(LoginActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, SignInActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(LoginActivity.this, "User Already Exists!", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this, "Password does not matched!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        AHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignInActivity.class);
                startActivity(i);
            }
        });

    }
}