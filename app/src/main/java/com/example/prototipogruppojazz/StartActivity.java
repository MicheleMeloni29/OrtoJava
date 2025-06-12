package com.example.prototipogruppojazz;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {
    Button accedi,registrati;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        accedi=findViewById(R.id.buttonLogin);
        registrati=findViewById(R.id.buttonSignin);

        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(StartActivity.this, LoginActivity.class);

                startActivity(login);
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(StartActivity.this, SigninActivity.class);

                startActivity(signin);
            }
        });

    }
}