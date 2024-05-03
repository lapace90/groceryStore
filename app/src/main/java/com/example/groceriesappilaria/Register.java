package com.example.groceriesappilaria;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText email, passwd1, passwd2, userName;

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        passwd1 = findViewById(R.id.registerPassword1);
        passwd2 = findViewById(R.id.registerPassword2);
        btnRegister=findViewById(R.id.registerBtn);
        userName = findViewById(R.id.userName);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserContract userContract = new UserContract(Register.this);
                userContract.insertionCLIENTS(email.getText().toString(), passwd1.getText().toString(), userName.getText().toString());
                int idClient = -1;

                if (idClient != -1) {
                    Toast.makeText(getApplicationContext(), "Your account is now registered", Toast.LENGTH_LONG).show();
                    Intent registerIntent = new Intent(Register.this, Welcome.class);
                    startActivity(registerIntent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_LONG).show();
                }
            }
        });




        Log.d("Database", "Creating database...");
        UserContract maSQLdb = new UserContract(this);
        Cursor myCursor = maSQLdb.readTable();
        maSQLdb.close();
    }
}