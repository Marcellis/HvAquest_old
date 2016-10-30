package com.example.marmm.ninjagospeurtocht;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class VraagActivity extends AppCompatActivity {

    RadioGroup radiogroup;
    Button antwoordButton;
    String[] items;
    TextView vraag;
    String juisteAntwoord;
    RadioButton antwoord;
    RadioButton antwoord1;
    RadioButton antwoord2;
    RadioButton antwoord3;
    AlertDialog.Builder alertDialog;
    int vraagnummer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraag);

        antwoordButton = (Button) findViewById(R.id.buttonAntwoord);
        vraag = (TextView) findViewById(R.id.textVraag);
        vraag.setText(getString(R.string.vraag1));


        vraagnummer= getIntent().getIntExtra("vraagnummer",-1);

        String antwoorden = "antwoorden"+vraagnummer;

        //items = getResources().getStringArray(R.array.antwoorden);

        int holderint = getResources().getIdentifier(antwoorden, "array",
                this.getPackageName()); // You had used "name"
         items = getResources().getStringArray(holderint);

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        antwoord1 = (RadioButton) findViewById(R.id.radioButton1);
        antwoord2 = (RadioButton) findViewById(R.id.radioButton2);
        antwoord3 = (RadioButton) findViewById(R.id.radioButton3);

        antwoord1.setText(items[1]);
        antwoord2.setText(items[2]);
        antwoord3.setText(items[3]);

        juisteAntwoord = items[0];



        antwoordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radiogroup.getCheckedRadioButtonId();



                {
                    antwoord = (RadioButton) findViewById(selectedId);
                }
                if (antwoord.getText().equals(juisteAntwoord)) {

                    if (vraagnummer==1)
                    {
                        Intent intent = new Intent(VraagActivity.this, EndActivity.class);
                        startActivity(intent);
                    }

//
//                    alertDialog = new AlertDialog.Builder(VraagActivity.this);
//                    alertDialog.setMessage("Goed gedaan Ninja, je mag door naar de volgende vraag");
//
//                    // Setting Positive "Yes" Button
//                    alertDialog.setPositiveButton("Volgende vraag", new DialogInterface.OnClickListener() {
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    });
                }
                   else {

                    alertDialog = new AlertDialog.Builder(VraagActivity.this);
                    alertDialog.setNegativeButton("Nog een keer proberen Ninja", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.cancel();
                        }
                    });


                }
                alertDialog.show();
            }
        });


    }


}
