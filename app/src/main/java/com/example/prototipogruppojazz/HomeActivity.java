package com.example.prototipogruppojazz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    Button ilMioOrto,logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ilMioOrto=findViewById(R.id.buttonIlMioOrto);

        logout=findViewById(R.id.buttonLogout);


        ilMioOrto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(HomeActivity.this, StartActivity.class);//deve andare nella pagina il mio orto

                startActivity(login);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(HomeActivity.this, StartActivity.class);

                startActivity(login);
            }
        });
    }
}