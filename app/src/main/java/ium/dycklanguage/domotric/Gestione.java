package ium.dycklanguage.domotric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class Gestione extends AppCompatActivity {

    static TextView[] nomeStanza = new TextView[3];
    static TextView[] statoStanza = new TextView[3];
    static TextView[] percentualeStanza = new TextView[3];
    static Switch[] bottone = new Switch[3];
    static String selezione;
    View[] zona = new View[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione);

        nomeStanza[0] = (TextView) findViewById(R.id.nomeStanza1);
        nomeStanza[1] = (TextView) findViewById(R.id.nomeStanza2);
        nomeStanza[2] = (TextView) findViewById(R.id.nomeStanza3);

        statoStanza[0] = (TextView) findViewById(R.id.parametro1);
        statoStanza[1] = (TextView) findViewById(R.id.parametro2);
        statoStanza[2] = (TextView) findViewById(R.id.parametro3);

        bottone[2] = (Switch) findViewById(R.id.switch3);

        zona[2] = findViewById(R.id.id3);

        nomeStanza[0].setText(MainActivity.stanza.get(0).getNome());
        nomeStanza[1].setText(MainActivity.stanza.get(1).getNome());
        nomeStanza[2].setText(MainActivity.stanza.get(2).getNome());

        statoStanza[0].setText("Non azionato");
        statoStanza[1].setText("Non azionato");
        statoStanza[2].setText("22°C");

        bottone[2].setChecked(true);

        zona[2].setOnClickListener(new View.OnClickListener(){

            public void onClick(View arg0){

                Intent activity = new Intent(getBaseContext(), Riscaldamento.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });
    }
}
