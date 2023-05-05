package com.avtosola.pici.miki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button bt_back = (Button) findViewById(R.id.back);
        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button bt_registracija = (Button) findViewById(R.id.registriraj);
        bt_registracija.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText first_nameInput = (EditText) findViewById(R.id.first_name);
                EditText last_nameInput = (EditText) findViewById(R.id.last_name);
                EditText emailInput = (EditText) findViewById(R.id.email);
                EditText passwordInput = (EditText) findViewById(R.id.password);
                EditText repeat_passwordInput = (EditText) findViewById(R.id.repeat_password);

                TextView messageText = (TextView) findViewById(R.id.text_input_error);
                TextView passwordMessageText = (TextView) findViewById(R.id.password_strength_message);

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

            }
        });
    }
}
