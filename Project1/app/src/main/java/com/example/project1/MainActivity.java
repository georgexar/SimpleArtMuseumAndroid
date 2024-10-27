package com.example.project1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("ArtAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        editor.putInt("dali_image", R.drawable.dali);
        editor.putString("dali_description", getString(R.string.dalidescription));
        editor.putString("dali_moredescription", getString(R.string.dalimoredescription));

        editor.putInt("van_image", R.drawable.van);
        editor.putString("van_description", getString(R.string.vandescription));
        editor.putString("van_moredescription", getString(R.string.vanmoredescription));

        editor.putInt("picasso_image", R.drawable.picasso);
        editor.putString("picasso_description", getString(R.string.picassodescription));
        editor.putString("picasso_moredescription", getString(R.string.picassomoredescription));

        editor.putInt("dalipaint_image", R.drawable.dalipaint);
        editor.putString("dalipaint_description", getString(R.string.dalipaintdescription));
        editor.putString("dalipaint_moredescription", getString(R.string.dalipaintmoredescription));

        editor.putInt("vanpaint_image", R.drawable.vanpaint);
        editor.putString("vanpaint_description", getString(R.string.vanpaintdescription));
        editor.putString("vanpaint_moredescription", getString(R.string.vanpaintmoredescription));

        editor.putInt("picassopaint_image", R.drawable.picassopaint);
        editor.putString("picassopaint_description", getString(R.string.picassopaintdescription));
        editor.putString("picassopaint_moredescription", getString(R.string.picassopaintmoredescription));


        editor.apply();


    }


    public void moveRoom1(View v)
    {
        Intent intent = new Intent(MainActivity.this ,Room1Activity.class );
        startActivity(intent);

    }

    public void moveRoom2(View v)
    {
        Intent intent = new Intent(MainActivity.this ,Room2Activity.class );
        startActivity(intent);

    }

}