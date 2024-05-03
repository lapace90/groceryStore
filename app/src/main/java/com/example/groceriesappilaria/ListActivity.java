package com.example.groceriesappilaria;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private EditText editTextQuantity, editTextCategory;
    private Button buttonAddToList;
    private ListView listViewItems;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // Inizializzazione delle viste
        editTextQuantity = findViewById(R.id.editTextQuantity);
        editTextCategory = findViewById(R.id.editTextCategory);
        buttonAddToList = findViewById(R.id.buttonAddToList);
        listViewItems = findViewById(R.id.listViewItems);

        // Inizializzazione della lista degli elementi
        itemList = new ArrayList<>();

        // Inizializzazione dell'adapter per la ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemList);
        listViewItems.setAdapter(adapter);

        // Gestione del clic sul pulsante "Add to List"
        buttonAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ottieni il testo inserito negli EditText
                String quantity = editTextQuantity.getText().toString();
                String category = editTextCategory.getText().toString();

                // Crea la stringa da aggiungere alla lista
                String listItem = "Quantity: " + quantity + ", Category: " + category;

                // Aggiungi la stringa alla lista degli elementi
                itemList.add(listItem);

                // Notifica all'adapter che i dati sono stati modificati
                adapter.notifyDataSetChanged();

                // Cancella il testo dagli EditText
                editTextQuantity.setText("");
                editTextCategory.setText("");
            }
        });
    }
}
