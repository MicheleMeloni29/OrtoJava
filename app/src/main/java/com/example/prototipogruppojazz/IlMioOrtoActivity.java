package com.example.prototipogruppojazz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextThemeWrapper;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IlMioOrtoActivity extends AppCompatActivity {

    Button aggiungi;
    ImageView optionsButton;

    /*da gestire la visualizzazione delle piante nell'orto se presenti o non*/
    /*se non si hanno piante messe allora meglio far sparire la sezione*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_il_mio_orto);

        aggiungi=findViewById(R.id.buttonInserisciPianta);
        optionsButton=findViewById(R.id.optionsButton);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        int numElements = 1; // Replace this with the actual number of elements you want to display
        int numRows = (numElements + 2) / 3;

        gridLayout.setRowCount(numRows); // Set the number of rows dynamically

        int screenWidth = getResources().getDisplayMetrics().widthPixels; // Get screen width in pixels
        int paddingPx = dpToPx(16); // Padding between images in pixels

        // Calculate the available width for each image (subtracting padding and space on the sides)
        int availableWidth = screenWidth - 2 * paddingPx;

        // Divide the available width by 3 to get the width of each image
        int desiredWidth = availableWidth / 3;


        int desiredHeight = desiredWidth;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < 3; j++) {
                int index = i * 3 + j;
                if (index < numElements) {
                    ImageView imageView = new ImageView(this);
                    GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                    params.width = 0; // Set width to 0 to use column weight
                    params.height = GridLayout.LayoutParams.WRAP_CONTENT;
                    params.columnSpec = GridLayout.spec(j, 1f); // Set the column weight to 1f


                    // Set a click listener for each ImageView
                    //passeremo un id per la gestione
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Handle the click event here
                            // You can use the 'index' variable to identify which image was clicked
                            Toast.makeText(IlMioOrtoActivity.this, "Image " + index + " clicked", Toast.LENGTH_SHORT).show();
                            //Intent inserisciPianta = new Intent(IlMioOrtoActivity.this, sezionePiantaInseribileActivity.class);

                            //startActivity(inserisciPianta);
                        }
                    });

                    gridLayout.addView(imageView);
                }
            }
        }

        optionsButton.setOnClickListener(v -> {
            ContextThemeWrapper themedContext = new ContextThemeWrapper(this, R.style.CustomPopupMenu);
            PopupMenu popupMenu = new PopupMenu(themedContext, optionsButton);
            popupMenu.inflate(R.menu.options_menu);

            // Inflate custom layout for divider item
            MenuInflater inflater = popupMenu.getMenuInflater();
            inflater.inflate(R.menu.options_menu, popupMenu.getMenu());

            // Colore verde per il testo
            for (int i = 0; i < popupMenu.getMenu().size(); i++) {
                MenuItem item = popupMenu.getMenu().getItem(i);
                SpannableString span = new SpannableString(item.getTitle());
                span.setSpan(new ForegroundColorSpan(Color.parseColor("#36A266")), 0, span.length(), 0);
                item.setTitle(span);
            }

            popupMenu.setOnMenuItemClickListener(item -> {
                int id = item.getItemId();
                if (id == R.id.opzionePassword) {
                    startActivity(new Intent(IlMioOrtoActivity.this, ModificaPasswordActivity.class));
                    return true;
                } else if (id == R.id.opzioneNotifiche) {
                    return true;
                } else if (id == R.id.opzioneLogout) {
                    startActivity(new Intent(IlMioOrtoActivity.this, StartActivity.class));
                    return true;
                }
                return false;
            });;

            popupMenu.show();

        });

        aggiungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(IlMioOrtoActivity.this, InserisciPiantaActivity.class);

                startActivity(login);
            }
        });




    }
    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

}