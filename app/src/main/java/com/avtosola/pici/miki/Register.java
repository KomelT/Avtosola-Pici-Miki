package com.avtosola.pici.miki;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

@RequiresApi(api = Build.VERSION_CODES.Q)
public class Register extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button bt_back = findViewById(R.id.back);
        bt_back.setOnClickListener(v -> {
            Intent intent = new Intent(Register.this,MainActivity.class);
            startActivity(intent);
        });

        Button bt_registracija = findViewById(R.id.registriraj);
        bt_registracija.setOnClickListener(v -> {

            EditText first_nameInput = findViewById(R.id.first_name);
            EditText last_nameInput = findViewById(R.id.last_name);
            EditText emailInput = findViewById(R.id.email);
            EditText passwordInput = findViewById(R.id.password);
            EditText repeat_passwordInput = findViewById(R.id.repeat_password);

            TextView messageText = findViewById(R.id.text_input_error);

            String first_name = String.valueOf(first_nameInput.getText());
            String last_name = String.valueOf(last_nameInput.getText());
            String email = String.valueOf(emailInput.getText());
            String password = String.valueOf(passwordInput.getText());
            String repeat_password = String.valueOf(repeat_passwordInput.getText());

            if (first_name.isBlank() || last_name.isBlank() || email.isBlank() || password.isBlank() || repeat_password.isBlank() ) {
                messageText.setText("Vsa polja morajo biti zapoljnjena!");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                messageText.setText("Email mora biti pravilen!");
            } else if (!password.equals(repeat_password)) {
                messageText.setText("Gesli morata biti enaki!");
            } else if (password.length() < 8) {
                messageText.setText("Geslo mora imeti vsaj 8 znakov!");
            } else {
                messageText.setText("");
            }

        });
    }
}
