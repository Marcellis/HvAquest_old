package com.example.marmm.ninjagospeurtocht;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vraag);

        antwoordButton = (Button) findViewById(R.id.buttonAntwoord);
        vraag = (TextView) findViewById(R.id.textVraag);
        vraag.setText(getString(R.string.vraag1));


        items = getResources().getStringArray(R.array.antwoorden1);

        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);
        antwoord1 = (RadioButton) findViewById(R.id.radioButton1);
        antwoord2 = (RadioButton) findViewById(R.id.radioButton2);
        antwoord3 = (RadioButton) findViewById(R.id.radioButton3);

        antwoord1.setText(items[1]);
        antwoord2.setText(items[2]);
        antwoord3.setText(items[3]);

        juisteAntwoord = items[0];

        alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Heb je het juist Ninja?");

        antwoordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId=radiogroup.getCheckedRadioButtonId();
                antwoord = (RadioButton) findViewById(selectedId);
                if (antwoord.getText().equals(juisteAntwoord)) {
                    alertDialog.setMessage("Goed gedaan Ninja");
                }
                   else {
                    alertDialog.setMessage("Nog een keer proberen Ninja");

                }
                alertDialog.show();
            }
        });



    }



}
