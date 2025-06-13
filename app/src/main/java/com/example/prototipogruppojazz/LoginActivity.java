package com.example.prototipogruppojazz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText editEmail, editPassword;
    Button loginBase, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword1);
        loginBase = findViewById(R.id.buttonLoginBase);
        backButton = findViewById(R.id.buttonBack); // Assicurati di avere questo bottone nel layout

        loginBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputUsername = editEmail.getText().toString().trim();
                String inputPassword = editPassword.getText().toString().trim();

                SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                String savedUsername = prefs.getString("username", null);
                String savedPassword = prefs.getString("password", null);

                if (savedUsername == null || savedPassword == null) {
                    Toast.makeText(LoginActivity.this, "Nessun utente registrato", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (inputUsername.equals(savedUsername) && inputPassword.equals(savedPassword)) {
                    Toast.makeText(LoginActivity.this, "Login effettuato!", Toast.LENGTH_SHORT).show();

                    // Vai a IlMioOrtoActivity
                    Intent orto = new Intent(LoginActivity.this, IlMioOrtoActivity.class);
                    startActivity(orto);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Username o password errati", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(back);
                finish();
            }
        });
    }
}
