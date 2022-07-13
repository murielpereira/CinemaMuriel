package com.example.cinema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void chamar_settings(View view) {
        Intent settings = new Intent(this, SettingsActivity.class);
        startActivity(settings);
    }

    public void chamar_camera(View view) {
        Intent settings = new Intent(this, CameraActivity.class);
        startActivity(settings);
    }
}
