package ium.dycklanguage.domotric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import ium.dycklanguage.domotric.classi.Listatore;

public class Programmazione extends AppCompatActivity {

    ImageView addButton;
    Switch avviaTutte;
    Listatore adapter;
    ListView list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmazione);

        this.setTitle("Gestione programmazioni");

        avviaTutte = (Switch) findViewById(R.id.abilitaAzioni);
        addButton = (ImageView) findViewById(R.id.addButtonP);


        list1 = (ListView)this.findViewById(R.id.azioneProgrammateLista);
        adapter = new Listatore(Programmazione.this, MainActivity.automazione);
        list1.setAdapter(adapter);

        avviaTutte.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (MainActivity.automazione.size() > 0) {
                    if (isChecked) {

                        avviaTutte.setChecked(true);
                        Toast.makeText(Programmazione.this, "Avviate tutte le azioni programmate", Toast.LENGTH_LONG).show();

                    } else {

                        avviaTutte.setChecked(false);

                    }
                }

            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                Intent activity = new Intent(getBaseContext(), NuovaProgrammazione.class);
                //avvia la finestra corrispondente
                startActivity(activity);
                finish();
            }
        });

    }


}
