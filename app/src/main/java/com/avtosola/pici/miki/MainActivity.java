package com.avtosola.pici.miki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_prijava = findViewById(R.id.login);

        EditText emailInput = findViewById(R.id.username);
        EditText passwordInput = findViewById(R.id.password);

        TextView errorMessageText = findViewById(R.id.errorMessage);

        bt_prijava.setOnClickListener(v -> {
            for (int i = 0; i < kandidati.length; i++) {
                if (kandidati[i].preveriPrijavo(emailInput.getText().toString(), passwordInput.getText().toString())) {
                   // Intent intent = new Intent(MainActivity.this,Register.class);
                   // startActivity(intent);
                   // TODO Implement redirect to right page
                    return;
                }

                errorMessageText.setText("Uporabniško ime ali geslo nista pravilna!");
            }

        });

        Button bt_registracija = findViewById(R.id.register);
        bt_registracija.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,Register.class);
            startActivity(intent);
        });
    }

    Kandidat Tilen = new Kandidat("Tilen", "Komel", "Ljubljana 15, 1000 Ljubljana", 343243412, 04065434, "tilen.komel@gmail.com", "a517ca91cda1d379cb09771427054093", true, true, true, 0, true, 24, 0, true);

    Kandidat[] kandidati = {Tilen};
}