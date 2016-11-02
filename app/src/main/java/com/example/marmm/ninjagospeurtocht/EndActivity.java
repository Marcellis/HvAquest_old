package com.example.marmm.ninjagospeurtocht;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewAanwijzing);


        try {
            InputStream stream = getAssets().open("speeltuinkleinedichter.jpg");
            Drawable d = Drawable.createFromStream(stream, null);
            imageView.setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
