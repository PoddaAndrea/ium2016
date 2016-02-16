package ium.dycklanguage.domotric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Gestione extends AppCompatActivity {

    static TextView[] nomeStanza = new TextView[3];
    static TextView[] statoStanza = new TextView[3];
    static TextView[] percentualeStanza = new TextView[3];
    static Switch[] bottone = new Switch[3];
    static String selezione;
    View[] zona = new View[3];

    Integer valore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione);

        this.setTitle("Gestione riscaldamento");

        nomeStanza[0] = (TextView) findViewById(R.id.nomeStanza1);
        nomeStanza[1] = (TextView) findViewById(R.id.nomeStanza2);
        nomeStanza[2] = (TextView) findViewById(R.id.nomeStanza3);

        statoStanza[0] = (TextView) findViewById(R.id.parametro1);
        statoStanza[1] = (TextView) findViewById(R.id.parametro2);
        statoStanza[2] = (TextView) findViewById(R.id.parametro3);

        bottone[0] = (Switch) findViewById(R.id.switch1);
        bottone[1] = (Switch) findViewById(R.id.switch2);
        bottone[2] = (Switch) findViewById(R.id.switch3);

        zona[2] = findViewById(R.id.id3);

        nomeStanza[0].setText(MainActivity.stanza.get(0).getNome());
        nomeStanza[1].setText(MainActivity.stanza.get(1).getNome());
        nomeStanza[2].setText(MainActivity.stanza.get(2).getNome());

        valore = MainActivity.stanza.get(2).getPercentualeRiscaldamento();


        statoStanza[0].setText("Non azionato");
        statoStanza[1].setText("Non azionato");
        statoStanza[2].setText("Attivato\t " + valore.toString() + "°C");

        if (MainActivity.stanza.get(2).isRiscaldamento()) {
            bottone[2].setChecked(true);
            statoStanza[2].setText("Attivato\t " + valore.toString() + "°C");
        }
        else {
            bottone[2].setChecked(false);
            statoStanza[2].setText("Non azionato");
        }

        bottone[0].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    bottone[0].setChecked(true);
                    Toast.makeText(Gestione.this, "Riscaldamento attivato in Cucina", Toast.LENGTH_LONG).show();
                    statoStanza[0].setText("Attivato\t 22°C");


                } else {

                    bottone[0].setChecked(false);
                    Toast.makeText(Gestione.this, "Riscaldamento disattivato in Cucina", Toast.LENGTH_LONG).show();
                    statoStanza[0].setText("Non azionato");


                }

            }
        });

        bottone[1].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    bottone[1].setChecked(true);
                    Toast.makeText(Gestione.this, "Riscaldamento attivato in Salone", Toast.LENGTH_LONG).show();
                    statoStanza[1].setText("Attivato\t 25°C");

                } else {

                    bottone[1].setChecked(false);
                    Toast.makeText(Gestione.this, "Riscaldamento disattivato in Salone", Toast.LENGTH_LONG).show();
                    statoStanza[1].setText("Non azionato");

                }

            }
        });

        bottone[2].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    bottone[2].setChecked(true);
                    MainActivity.stanza.get(2).setRiscaldamento(true);
                    Toast.makeText(Gestione.this, "Riscaldamento attivato in Camera", Toast.LENGTH_LONG).show();
                    statoStanza[2].setText("Attivato\t " + valore.toString() + "°C");

                } else {

                    bottone[2].setChecked(false);
                    MainActivity.stanza.get(2).setRiscaldamento(false);
                    Toast.makeText(Gestione.this, "Riscaldamento disattivato in Camera", Toast.LENGTH_LONG).show();
                    statoStanza[2].setText("Non azionato");

                }

            }
        });


        zona[2].setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent activity = new Intent(getBaseContext(), Riscaldamento.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });
    }
}
