package com.example.marmm.hvaquest;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class VraagActivity extends AppCompatActivity {

    RadioGroup radiogroup;
    Button antwoordButton;
    String[] items;
    TextView vraagTextview;
    String juisteAntwoord;
    RadioButton antwoord;
    RadioButton antwoord1;
    RadioButton antwoord2;
    RadioButton antwoord3;
    ImageView imageView;
    private int vraagnummer = 1;
    public static final String vraagKey = "vraagKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraag);

        antwoordButton = (Button) findViewById(R.id.buttonAntwoord);
        imageView = (ImageView) findViewById(R.id.imageView);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        antwoord1 = (RadioButton) findViewById(R.id.radioButton1);
        antwoord2 = (RadioButton) findViewById(R.id.radioButton2);
        antwoord3 = (RadioButton) findViewById(R.id.radioButton3);
        vraagTextview = (TextView) findViewById(R.id.textVraag);

        vulVraag(vraagnummer);

        antwoordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radiogroup.getCheckedRadioButtonId();

                if (selectedId == -1)
                    Snackbar.make(view, "Kies een antwoord", Snackbar.LENGTH_LONG).setAction("Action", null).show();


                else {
                    antwoord = (RadioButton) findViewById(selectedId);
                    if (antwoord.getText().equals(juisteAntwoord)) {

                        Intent intent = new Intent(VraagActivity.this, EndActivity.class);
                        intent.putExtra(vraagKey,vraagnummer);
                        startActivityForResult(intent,1234);
                    } else {
                        Snackbar.make(view, "Nog een keer proberen Ninja", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                    }

                }

            }

        });
    }


    public void vulVraag (int vraagnummer){

        //   vullen vraag
        String vraag = "vraag" + vraagnummer;
        int holderint1 = getResources().getIdentifier(vraag, "string",
                this.getPackageName()); // You had used "name"
        String vraagScherm = getResources().getString(holderint1);

        vraagTextview.setText(vraagScherm);

        // vullen antwoorden
        String antwoorden = "antwoorden" + vraagnummer;
        int holderint = getResources().getIdentifier(antwoorden, "array",
                this.getPackageName()); // You had used "name"
        items = getResources().getStringArray(holderint);
        antwoord1.setText(items[1]);
        antwoord2.setText(items[2]);
        antwoord3.setText(items[3]);
        juisteAntwoord = items[0];
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Check if the result code is the right one
        if (resultCode == Activity.RESULT_OK) {
            //Check if the request code is correct
            if (requestCode == 1234) {
                vraagnummer = data.getIntExtra(EndActivity.aanwijzingKey,-1);
                 vulVraag (vraagnummer);
                radiogroup.clearCheck();


            }
        }

    }
}