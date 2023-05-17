package com.avtosola.pici.miki;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


@RequiresApi(api = Build.VERSION_CODES.Q)
public class MainActivity extends AppCompatActivity {
    @SuppressWarnings("FieldMayBeFinal")
    private int loggedInUserId = -1;
    Kandidat Tilen = new Kandidat("Tilen", "Komel", "Ljubljana 15, 1000 Ljubljana", 343243412, 04065434, "tilen.komel@gmail.com", "a517ca91cda1d379cb09771427054093", true, true, true, 0, false, 0, 0, false);
    Kandidat[] kandidati = {Tilen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailInput = findViewById(R.id.username);
        EditText passwordInput = findViewById(R.id.password);

        emailInput.setText("tilen.komel@gmail.com");
        passwordInput.setText("TilenKomel");

        TextView errorMessageText = findViewById(R.id.errorMessage);

        Button bt_prijava = findViewById(R.id.login);
        bt_prijava.setOnClickListener(v -> {
            for (int i = 0; i < kandidati.length; i++) {
                if (kandidati[i].preveriPrijavo(emailInput.getText().toString(), passwordInput.getText().toString())) {
                   Intent intent = new Intent(MainActivity.this,UserProfile.class);
                   startActivity(intent);
                   errorMessageText.setText("");
                    KPrijaviSeNaCPPIzpit.kandidat = kandidati[i];
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
}