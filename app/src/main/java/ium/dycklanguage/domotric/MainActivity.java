package ium.dycklanguage.domotric;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import ium.dycklanguage.domotric.classi.Stanza;

public class MainActivity extends AppCompatActivity {

    static public ArrayList<Stanza> stanza = new ArrayList<>();
    public ImageView[] immagini = new ImageView[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        immagini[0] = (ImageView) findViewById(R.id.immagine1);
        immagini[1] = (ImageView) findViewById(R.id.immagine2);
        immagini[2] = (ImageView) findViewById(R.id.immagine3);
        immagini[3] = (ImageView) findViewById(R.id.immagine4);
        immagini[4] = (ImageView) findViewById(R.id.immagine5);
        immagini[5] = (ImageView) findViewById(R.id.immagine6);

        stanza.add(new Stanza("Cucina"));
        stanza.add(new Stanza("Salone"));
        stanza.add(new Stanza("Camera"));


        immagini[0].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                Intent activity = new Intent(getBaseContext(), Luci.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });

        immagini[5].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                funzionalitaMancante();
            }
        });

        immagini[6].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                funzionalitaMancante();
            }
        });
    }


    /**alert che indica l'indisponibilità di funzioni*/
    void funzionalitaMancante(){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Lavori in corso");
        builder.setMessage("Funzionalità non ancora disponibile");
        builder.setCancelable(false);
        builder.setPositiveButton("Ho capito", new DialogInterface.OnClickListener() {
            @Override

            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();

            }
        });

        builder.show();

    }
}
