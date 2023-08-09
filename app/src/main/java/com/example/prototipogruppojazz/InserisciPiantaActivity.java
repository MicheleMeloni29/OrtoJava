package com.example.prototipogruppojazz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


public class InserisciPiantaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserisci_pianta);

        GridLayout gridLayout = findViewById(R.id.gridLayoutInserisci);

        int numElements = 9; // Replace this with the actual number of elements you want to display
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

                    imageView.setLayoutParams(params);
                    //printa solo logo per ora. bisogna creare una classe di piante e far ciclare un array
                    Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
                    Bitmap resizedBitmap = Bitmap.createScaledBitmap(originalBitmap, desiredWidth, desiredHeight, false);
                    imageView.setImageBitmap(resizedBitmap);

                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setPadding(paddingPx, paddingPx, paddingPx, paddingPx);

                    // Set a click listener for each ImageView
                    //passeremo un id per la gestione
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Handle the click event here
                            // You can use the 'index' variable to identify which image was clicked
                            Toast.makeText(InserisciPiantaActivity.this, "Image " + index + " clicked", Toast.LENGTH_SHORT).show();
                            Intent inserisciPianta = new Intent(InserisciPiantaActivity.this, sezionePiantaInseribileActivity.class);

                            startActivity(inserisciPianta);
                        }
                    });

                    gridLayout.addView(imageView);
                }
            }
        }
    }

    public int dpToPx(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }
}
