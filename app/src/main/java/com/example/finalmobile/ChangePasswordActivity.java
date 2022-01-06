package com.example.finalmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
    private EditText oldPass, newPass;
    private DatabaseHelper db;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        getSupportActionBar().hide();

        oldPass = findViewById(R.id.old_password);
        newPass = findViewById(R.id.new_password);
        btn = findViewById(R.id.btnChangePass);

        db = new DatabaseHelper(this);

        btn.setOnClickListener(view -> {
            String oldPassword = oldPass.getText().toString();
            String newPassword = newPass.getText().toString();
            SharedPreferences prefs = getSharedPreferences("PrefsFile", MODE_PRIVATE);
            String username = prefs.getString("username", "");

            // Validate input
            if(oldPassword.equals(newPassword)){
                Toast.makeText(ChangePasswordActivity.this, "New password should not match old password", Toast.LENGTH_LONG).show();
                return;
            }
            if(oldPassword.equals("") || newPassword.equals("")){
                Toast.makeText(ChangePasswordActivity.this, "All fields should not be empty", Toast.LENGTH_LONG).show();
                return;
            }
            if(!db.checkUsernamePassword(username, oldPassword)){
                Toast.makeText(ChangePasswordActivity.this, "Old password is wrong.", Toast.LENGTH_LONG).show();
                return;
            }

            if(db.changePassword(username, newPassword)){
                Toast.makeText(ChangePasswordActivity.this, "Done!", Toast.LENGTH_LONG).show();
                finish();
            }else{
                Toast.makeText(ChangePasswordActivity.this, "Something went wrong.", Toast.LENGTH_LONG).show();
            }
        });
    }
}