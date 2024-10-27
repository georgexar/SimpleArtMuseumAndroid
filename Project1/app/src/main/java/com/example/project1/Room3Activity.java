package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Room3Activity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Button button;
    private String fullDescription;
    private String description;
    private boolean isFullDescriptionShown = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.picturechanger);
        textView = findViewById(R.id.descriptionText);
        button = findViewById(R.id.changepaper);


        String itemKey = getIntent().getStringExtra("itemKey");


        SharedPreferences sharedPreferences = getSharedPreferences("ArtAppPrefs", MODE_PRIVATE);
        int imageResId = sharedPreferences.getInt(itemKey + "_image", -1);  // Default value -1 αν δεν υπάρχει
        description = sharedPreferences.getString(itemKey + "_description", "No description available");
        fullDescription = sharedPreferences.getString(itemKey + "_moredescription", "No full description available");

        textView.setText(description);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }

        button.setOnClickListener(v -> {
            if (isFullDescriptionShown) {
                textView.setText(description);
            } else {
                textView.setText(fullDescription);
            }
            isFullDescriptionShown = !isFullDescriptionShown;
        });



    }
}