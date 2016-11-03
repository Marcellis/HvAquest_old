package com.example.marmm.ninjagospeurtocht;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class EndActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] imageNames = {R.drawable.lloyd, R.drawable.rabobank,R.drawable.speeltuinkleinedichter};
    private int aanwijzing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        final int aanwijzing = getIntent().getIntExtra("vraagnummer",-1);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewAanwijzing);
        Button terugButton = (Button) findViewById(R.id.buttonAanwijzing);

        imageView.setImageResource(imageNames[aanwijzing]);

        terugButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent data = new Intent();
               data.putExtra("vraagnummer",aanwijzing++);
                //Send the result back to the activity
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}
