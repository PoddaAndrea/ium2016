package ium.dycklanguage.domotric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class Gestione extends AppCompatActivity {

    static TextView[] nomeStanza = new TextView[3];
    static TextView[] statoStanza = new TextView[3];
    static TextView[] percentualeStanza = new TextView[3];
    static Switch[] bottone = new Switch[3];
    static String selezione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione);



    }
}
