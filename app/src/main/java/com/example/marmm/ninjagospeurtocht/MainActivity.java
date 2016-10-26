package com.example.marmm.ninjagospeurtocht;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] items = getResources().getStringArray(R.array.questions);

        TextView vraag = (TextView) findViewById(R.id.textView);
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup);

    }


    public void onclickVolgende (View view){


        RadioButton selectRadio = (RadioButton) findViewById(radiogroup.getCheckedRadioButtonId());
        String opinion = selectRadio.getText().toString();
        Toast.makeText(this, opinion, Toast.LENGTH_SHORT).show();

    }


    public void onclickVorige (View view){
        Toast.makeText(this, "vorige", Toast.LENGTH_SHORT).show();
    }

}
