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

        ImageView optionsButton = findViewById(R.id.optionsButton);
        Button aggiungi=findViewById(R.id.aggiungiPianta);

        optionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(sezionePiantaInseribileActivity.this, optionsButton);
                popupMenu.inflate(R.menu.options_menu);

                // Inflate custom layout for divider item
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.divider_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        // Handle menu item clicks
                        switch (item.getItemId()) {
                            case R.id.opzionePassword:
                                Intent opzionePassword= new Intent(sezionePiantaInseribileActivity.this,ModificaPasswordActivity.class);
                                startActivity(opzionePassword);
                                return true;
                            case R.id.opzioneNotifiche:
                                // Handle option 2 click
                                return true;
                            case R.id.opzioneLogout:
                                Intent opzioneLogout= new Intent(sezionePiantaInseribileActivity.this,StartActivity.class);
                                startActivity(opzioneLogout);
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popupMenu.show();
            }
        });

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