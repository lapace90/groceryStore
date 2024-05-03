package com.example.groceriesappilaria;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.userName);
        passwordEditText = findViewById(R.id.passwordTxt);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        boolean isNewUser = checkIfNewUser(username, password);

        if (isNewUser) {
            redirectToRegistration();
        } else {
            redirectToWelcomePage();
        }
    }

    private boolean checkIfNewUser(String username, String password) {
        try (UserContract userContract = new UserContract(this);
             SQLiteDatabase db = userContract.getReadableDatabase();
             Cursor cursor = db.rawQuery("SELECT * FROM " + UserContract.NOM_TABLE +
                             " WHERE " + UserContract.COL3 + " = ? AND " +
                             UserContract.COL2 + " = ?",
                     new String[]{username, password})) {

            return !cursor.moveToFirst();
        }
    }

    private void redirectToRegistration() {
        Intent registerIntent = new Intent(Login.this, Register.class);
        startActivity(registerIntent);
    }

    private void redirectToWelcomePage() {
        Intent welcomeIntent = new Intent(Login.this, Welcome.class);
        Toast.makeText(Login.this, "Welcome!", Toast.LENGTH_SHORT).show();
        startActivity(welcomeIntent);
        finish();
    }
}
