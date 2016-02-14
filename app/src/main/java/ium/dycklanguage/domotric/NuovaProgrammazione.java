package ium.dycklanguage.domotric;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ium.dycklanguage.domotric.classi.DatePickerFragment;

public class NuovaProgrammazione extends AppCompatActivity {

    EditText dataInizio, dataFine, oraInizio, oraFine, stanza, tipo;
    DatePickerFragment datePickerFragment;

    Button conferma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuova_programmazione);

        stanza = (EditText) findViewById(R.id.stanzaNP);
        tipo = (EditText) findViewById(R.id.tipologiaNP);

        dataInizio = (EditText) findViewById(R.id.dataINP);
        dataFine = (EditText) findViewById(R.id.dataFNP);
        oraInizio = (EditText) findViewById(R.id.oraINP);
        oraFine = (EditText) findViewById(R.id.oraFNP);


        dataInizio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerFragment.show(getFragmentManager(), "datePicker");
            }
        });

        dataFine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerFragment.show(getFragmentManager(), "datePicker");
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvaeChiudi();
            }
        });
    }


    void selezionaStanza(){

        String[] stanze = new String[3];
        stanze[0] = "Cucina";
        stanze[1] = "Camera";
        stanze[2] = "Salone";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scegli una stanza")
                .setItems(stanze, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                    }
                });

        builder.create();

    }

    void salvaeChiudi(){


        finish();
    }
}
