package com.example.prototipogruppojazz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SigninActivity extends AppCompatActivity {

    Button registratiBase, backButton;
    EditText editUsername, editEmail, editPassword1, editPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Associa i campi
        registratiBase = findViewById(R.id.buttonSigninBase);
        editUsername = findViewById(R.id.editUsername);
        editEmail = findViewById(R.id.editEmail); // anche se non usato per il login
        editPassword1 = findViewById(R.id.editPassword1);
        editPassword2 = findViewById(R.id.editPassword2);
        backButton = findViewById(R.id.buttonBack);

        registratiBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editUsername.getText().toString().trim();
                String password1 = editPassword1.getText().toString().trim();
                String password2 = editPassword2.getText().toString().trim();

                if (username.isEmpty() || password1.isEmpty() || password2.isEmpty()) {
                    Toast.makeText(SigninActivity.this, "Compila tutti i campi", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password1.equals(password2)) {
                    Toast.makeText(SigninActivity.this, "Le password non corrispondono", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Salva le credenziali
                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("username", username);
                editor.putString("password", password1);
                editor.apply();

                Toast.makeText(SigninActivity.this, "Registrazione completata!", Toast.LENGTH_SHORT).show();

                // Torna alla schermata di login o start
                Intent login = new Intent(SigninActivity.this, StartActivity.class);
                startActivity(login);
                finish();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(SigninActivity.this, StartActivity.class);
                startActivity(back);
                finish();
            }
        });
    }
}
