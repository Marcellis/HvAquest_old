package com.example.marmm.ninjagospeurtocht;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

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
    AlertDialog.Builder alertDialog;
    ImageView imageView;
    private int vraagnummer = 1;

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


//        alertDialog = new AlertDialog.Builder(VraagActivity.this);
//        alertDialog.setMessage("Goed gedaan Ninja, je krijgt een aanwijzing");
//
//        // Setting Positive "Yes" Button
//        alertDialog.setPositiveButton("Aanwijzing", new DialogInterface.OnClickListener() {
//
//            public void onClick(DialogInterface dialog, int which) {
//        }
//        });
//        alertDialog.setNegativeButton("Nog een keer proberen Ninja", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//
//                dialog.cancel();
//            }
//        });


        antwoordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radiogroup.getCheckedRadioButtonId();

                if (selectedId == -1)
                    Toast.makeText(VraagActivity.this, "Kies een antwoord", Toast.LENGTH_SHORT).show();

                else {
                    antwoord = (RadioButton) findViewById(selectedId);
                    if (antwoord.getText().equals(juisteAntwoord)) {

                        Intent intent = new Intent(VraagActivity.this, EndActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(VraagActivity.this, "Nog een keer proberen Ninja!", Toast.LENGTH_SHORT).show();
                    }

                }

            }

        });
    }
}

