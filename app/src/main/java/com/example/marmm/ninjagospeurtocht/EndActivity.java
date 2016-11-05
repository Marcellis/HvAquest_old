package com.example.marmm.ninjagospeurtocht;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class EndActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] imageNames = {R.drawable.lloyd, R.drawable.rabobank,R.drawable.stadhuis, R.drawable.bioscoop, R.drawable.tandarts,R.drawable.schip, R.drawable.boog, R.drawable.speeltuinkleinedichter};
    private int aanwijzing;
    public static final String aanwijzingKey = "aanwijzingKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        aanwijzing = getIntent().getIntExtra(VraagActivity.vraagKey,-1);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewAanwijzing);
        Button terugButton = (Button) findViewById(R.id.buttonAanwijzing);

        imageView.setImageResource(imageNames[aanwijzing]);

        terugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
               data.putExtra(aanwijzingKey, ++aanwijzing);

                //Send the result back to the activity
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
