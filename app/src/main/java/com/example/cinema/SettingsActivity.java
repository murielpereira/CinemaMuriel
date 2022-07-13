package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void add_filme(View view) {
        Intent adicionar = new Intent(this, AdicionarActivity.class);
        startActivity(adicionar);
    }

    public void listar_filme(View view) {
        Intent adicionar = new Intent(this, ListarActivity.class);
        startActivity(adicionar);
    }
}