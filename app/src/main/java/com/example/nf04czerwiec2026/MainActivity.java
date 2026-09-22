package com.example.nf04czerwiec2026;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    EditText tytul, tresc;
    ArrayList<String> dataList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lista = findViewById(R.id.notatki);
        tytul = findViewById(R.id.tytul);
        tresc = findViewById(R.id.tresc);

        dataList = new ArrayList<>();
        dataList.add("Tenis \nGra z Ewa w poniedziałek");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dataList
        );
        lista.setAdapter(adapter);
    }

    public void dodaj(View view) {
        String tekstTytul = tytul.getText().toString().trim();
        String tekstTresc = tresc.getText().toString().trim();

        String nowaNotatka = tekstTytul + "\n" + tekstTresc;

        dataList.add(nowaNotatka);
        adapter.notifyDataSetChanged();

        tytul.setText("");
        tresc.setText("");
    }
}