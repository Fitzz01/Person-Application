package com.example.individualproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {

    EditText pass, phone;
    Button signInBtn;
    TextView YLA;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        pass      = findViewById(R.id.signIn_password);
        phone     = findViewById(R.id.signIn_phone);
        signInBtn = findViewById(R.id.SignIn_Btn);
        YLA       = findViewById(R.id.yetAccount);

        db        = new DBHelper(this);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pas   = pass.getText().toString();
                String Phone = phone.getText().toString();

                if(pas.equals("") || Phone.equals(""))
                    Toast.makeText(SignInActivity.this, "Enter All Requirement", Toast.LENGTH_SHORT).show();
                else{
                    boolean checkUserPP = db.checkPhoneAndPass(pas, Phone);
                    if(checkUserPP == true){
                        Toast.makeText(SignInActivity.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(SignInActivity.this, MainActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(SignInActivity.this, "Invalid Entrance", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        YLA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignInActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
    }
}