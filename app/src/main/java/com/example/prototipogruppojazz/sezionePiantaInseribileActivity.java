package com.example.prototipogruppojazz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;

public class sezionePiantaInseribileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sezione_pianta_inseribile);


        Button aggiungi=findViewById(R.id.aggiungiPianta);

        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gestire l'aggiunta di una pianta
                Intent aggiungi=new Intent(sezionePiantaInseribileActivity.this, IlMioOrtoActivity.class);
                startActivity(aggiungi);
            }
        });
    }
}