package com.example.groceriesappilaria;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText email, passwd1, passwd2;

    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        passwd1 = findViewById(R.id.registerPassword1);
        passwd2 = findViewById(R.id.registerPassword2);
        btnRegister=findViewById(R.id.registerBtn);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserContract userContract = new UserContract(Register.this);

                userContract.insertionCLIENTS("example@email.com", "password123");


                Intent registerIntent = new Intent(Register.this, Login.class);
                startActivity(registerIntent);


            }
        });



        Log.d("Database", "Creating database...");
        UserContract maSQLdb = new UserContract(this);
        Cursor myCursor = maSQLdb.readTable();
        maSQLdb.close();
    }
}