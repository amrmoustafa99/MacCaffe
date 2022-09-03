package com.example.maccoffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zacks(View view) {
        Intent intent=new Intent(MainActivity.this, SandwichesActivity.class);
        startActivity(intent);
    }

    public void anything(View view) {
    }
}