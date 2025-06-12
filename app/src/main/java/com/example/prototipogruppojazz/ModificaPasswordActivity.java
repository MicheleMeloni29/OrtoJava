package com.example.prototipogruppojazz;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ModificaPasswordActivity extends AppCompatActivity {

    Button conferma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_password);

        conferma=findViewById(R.id.buttonConfermaModificaPassword);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confermaPassword= new Intent(ModificaPasswordActivity.this,IlMioOrtoActivity.class);
                startActivity(confermaPassword);
            }
        });


    }
}