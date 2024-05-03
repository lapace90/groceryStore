package com.example.groceriesappilaria;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.database.Cursor;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.widget.ProgressBar;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.groceriesappilaria.R;



public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Handler handler;
    private ProgressBar pgBar;
    private boolean userLoggedIn = false; // Stato di accesso dell'utente

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        pgBar = findViewById(R.id.pgBar);
        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        }, 3000);




        // Simulazione: l'utente effettua l'accesso con successo
        onUserLoggedIn();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Se l'utente è autenticato, mostra il menu
        if (userLoggedIn) {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        } else {
            return false; // Non mostra il menu se l'utente non è autenticato
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.actionList) {
            Intent listIntent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(listIntent);
            return true;
        }
        if (id == R.id.actionAgain) {
            // Azioni per la voce "Buy Again"
            return true;
        }
        if (id == R.id.actionSettings) {
            // Azioni per la voce "Settings"
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Simula l'accesso dell'utente con successo
    private void onUserLoggedIn() {
        // Effettua le operazioni necessarie per l'accesso
        // (ad esempio, verifica le credenziali, avvia la sessione, ecc...)
        userLoggedIn = true;

        // Aggiorna il menu per riflettere lo stato di accesso
        invalidateOptionsMenu();
    }
}
