package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText etUsername, etPassword, etRepassword;
    private Button btnSignup;
    private TextView tvSignIn;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getSupportActionBar().hide();

        db = new DatabaseHelper(this);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etRepassword = findViewById(R.id.etRepassword);
        tvSignIn = findViewById(R.id.signupToLogin);
        btnSignup = findViewById(R.id.btnSignUp);

        btnSignup.setOnClickListener(view -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String repassword = etRepassword.getText().toString();

            if (username.equals("") || password.equals("") || repassword.equals("")) {
                Toast.makeText(SignupActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                if (password.equals(repassword)) {
                    Boolean checkUsername = db.checkUsername(username);
                    if (!checkUsername) {
                        Boolean insert = db.insertData(username, password);
                        if (!insert) {
                            Toast.makeText(SignupActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignupActivity.this, "This username already exists! Please Sign in.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SignupActivity.this, "Passwords don't much", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}