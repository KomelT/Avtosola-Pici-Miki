package com.avtosola.pici.miki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_registracija = findViewById(R.id.register);
        bt_registracija.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });
    }
}