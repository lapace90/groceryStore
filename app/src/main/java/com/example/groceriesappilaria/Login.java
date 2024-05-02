package com.example.groceriesappilaria;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private EditText passwordTxt, userTxt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        passwordTxt = findViewById(R.id.passwordTxt);
        userTxt = findViewById(R.id.userTxt);
        loginBtn = findViewById(R.id.btnLogin);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean newAccess = checkNewAccess();

                if (newAccess) {
                    // Se l'utente non esiste nel database, reindirizza alla pagina di registrazione
                    Intent registerIntent = new Intent(Login.this, Register.class);
                    startActivity(registerIntent);
                } else {

                        Intent i = new Intent(getApplicationContext(), Welcome.class);
                        Toast.makeText(Login.this, "Welcome!" , Toast.LENGTH_SHORT).show();
                        startActivity(i);
                        finish();
                    }
                }

        });
    }

    private boolean checkNewAccess() {
        String username = userTxt.getText().toString();
        String password = passwordTxt.getText().toString();
        // Implementa la logica per verificare se l'utente esiste già nel database
        // Questo è solo un esempio, dovresti sostituire questa implementazione con la tua logica effettiva
        boolean userExists = checkUserExists(username, password);

        // Se l'utente non esiste nel database, è un nuovo accesso
        return !userExists;
    }

    // Metodo per verificare se l'utente esiste già nel database
    private boolean checkUserExists(String username, String password) {
        // Implementa la logica per verificare se l'utente esiste già nel database
        // Questo è solo un esempio, dovresti sostituire questa implementazione con la tua logica effettiva
        return false;
    }
}
