package ium.dycklanguage.domotric;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NuovaProgrammazione extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuova_programmazione);

        //TODO gestione singole programmazioni
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

        //return builder.create();

    }

}
