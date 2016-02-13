package ium.dycklanguage.domotric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;

import ium.dycklanguage.domotric.classi.Listatore;

public class Programmazione extends AppCompatActivity {

    ImageView addButton;
    Switch avviaTutte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmazione);

        avviaTutte = (Switch) findViewById(R.id.abilitaAzioni);
        addButton = (ImageView) findViewById(R.id.addButtonP);

        //TODO gestione bottone generale

        ListView list1 = (ListView)this.findViewById(R.id.azioneProgrammateLista);
        Listatore adapter = new Listatore(Programmazione.this, MainActivity.automazione);
        list1.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent activity = new Intent(getBaseContext(), NuovaProgrammazione.class);
                //avvia la finestra corrispondente
                startActivity(activity);
            }
        });

    }
}
