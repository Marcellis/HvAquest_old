package com.example.marmm.hvaquest;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EndActivity extends AppCompatActivity {

    private int currentImageIndex = 0;
    private int[] imageNames = {R.drawable.nicolaes_tulphuis,
            R.drawable.fraijlemaborg,
            R.drawable.leeuwenburg,
            R.drawable.muller_lulofshuis,
            R.drawable.wibauthuis,
            R.drawable.studio_hva,
            R.drawable.theo_thijssenhuis,
            R.drawable.kohnstammhuis,
            R.drawable.benno_premselahuis,
            R.drawable.koetsier_montaignehuis,
            R.drawable.maagdenhuis};
    private int clue;
    public static final String clueKey = "clueKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        clue = getIntent().getIntExtra(QuestionActivity.questionKey, -1);

        ImageView imageView = (ImageView) findViewById(R.id.imageViewClue);
        Button backButton = (Button) findViewById(R.id.buttonClue);

        imageView.setImageResource(imageNames[clue]);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (clue == 10) {
                    Intent data = new Intent(EndActivity.this, FinishedActivity.class);
                    startActivity(data);
                } else {
                    Intent data = new Intent();
                    data.putExtra(clueKey, ++clue);

                    //Send the result back to the activity
                    setResult(Activity.RESULT_OK, data);
                    finish();
                }
            }
        });
    }
}
