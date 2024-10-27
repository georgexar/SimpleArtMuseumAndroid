package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Room2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_room2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button1 = findViewById(R.id.paintdalibutton);
        Button button2 = findViewById(R.id.paintvanbutton);
        Button button3 = findViewById(R.id.paintpicassobutton);

        button1.setOnClickListener(v -> openRoom3("dalipaint"));
        button2.setOnClickListener(v -> openRoom3("vanpaint"));
        button3.setOnClickListener(v -> openRoom3("picassopaint"));



    }



    private void openRoom3(String itemKey) {
        Intent intent = new Intent(Room2Activity.this, Room3Activity.class);
        intent.putExtra("itemKey", itemKey);
        startActivity(intent);
    }
}