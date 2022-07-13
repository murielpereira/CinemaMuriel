package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Cinema);
        setContentView(R.layout.activity_main);
    }

    public void chamar_welcome(View view) {
        Intent login = new Intent(this, HomeActivity.class);
        startActivity(login);
    }

    public void chamar_termos(View view) {
        Intent termos = new Intent(this, TermosActivity.class);
        startActivity(termos);
    }
}