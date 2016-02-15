package ium.dycklanguage.domotric;

/**
 * 	 Domotric - HCI final project, University of Cagliari
 *
     Copyright (C) 2016		Linguaggio del Dyck: Emanuel Fois, Alessio Manai, Andrea Podda, Corrado Sitzia

     This program is free software: you can redistribute it and/or modify
     it under the terms of the GNU General Public License as published by
     the Free Software Foundation, either version 3 of the License, or
     (at your option) any later version.
     This program is distributed in the hope that it will be useful,
     but WITHOUT ANY WARRANTY; without even the implied warranty of
     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
     GNU General Public License for more details.
     You should have received a copy of the GNU General Public License
     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 		https://github.com/PoddaAndrea/ium2016
 * */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import ium.dycklanguage.domotric.classi.*;

public class MainActivity extends AppCompatActivity {

    static public ArrayList<Stanza> stanza = new ArrayList<>();
    public ImageView[] immagini = new ImageView[6];
    static public ArrayList<ium.dycklanguage.domotric.classi.Programmazione> automazione = new ArrayList<>();

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

        stanza.add(new Stanza("Cucina", true, false, false, 5, 0, 0, true));
        stanza.add(new Stanza("Salone", false, false, false, 0, 0, 0, false));
        stanza.add(new Stanza("Camera", false, true, false, 0, 25, 0, false));

        /**gestione luci*/
        immagini[0].setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                funzionalitaMancante();

            }
        });

        /**tapparelle*/
        immagini[1].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                funzionalitaMancante();
            }
        });

        /**riscaldamento*/
        immagini[2].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                Intent activity = new Intent(getBaseContext(), Gestione.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });

        /**programmazione*/
        immagini[3].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                Intent activity = new Intent(getBaseContext(), Programmazione.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });

        /**nuova stanza**/
        immagini[4].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                funzionalitaMancante();
            }
        });

        /**impostazioni*/
        immagini[5].setOnClickListener(new View.OnClickListener(){

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
