package ium.dycklanguage.domotric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Riscaldamento extends AppCompatActivity {

    ImageView piu, meno, icona;
    TextView gradi;
    final Integer min = 0, max = 40;
    Integer valore;
    boolean acceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riscaldamento);

        this.setTitle("Imposta riscaldamento");

        acceso = MainActivity.stanza.get(2).isRiscaldamento();

        piu = (ImageView) findViewById(R.id.piuR);
        meno = (ImageView) findViewById(R.id.menoR);
        icona = (ImageView) findViewById(R.id.feedbackRiscaldamento);
        gradi = (TextView) findViewById(R.id.valoreR);

        valore = MainActivity.stanza.get(2).getPercentualeRiscaldamento();

        gradi.setText(valore.toString());

        updatePic();

        icona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (acceso){

                    icona.setImageResource(R.mipmap.logo_condizionatore);
                    acceso = false;
                } else
                    updatePic();

            }
        });

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore > min)
                    valore--;
                gradi.setText(valore.toString());

                updatePic();

                MainActivity.stanza.get(2).setPercentualeRiscaldamento(valore);

            }
        });


        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore < max)
                    valore++;
                gradi.setText(valore.toString());

                updatePic();

                MainActivity.stanza.get(2).setPercentualeRiscaldamento(valore);

            }
        });


    }

    public void updatePic(){

        if(!acceso)
            icona.setImageResource(R.mipmap.logo_condizionatore);

        if (valore < 20){

            icona.setImageResource(R.mipmap.logo_condizionatore2);
        }
        if (valore >= 20){

            icona.setImageResource(R.mipmap.logo_condizionatore3);

        }
        if (valore > 25){

            icona.setImageResource(R.mipmap.logo_condizionatore4);

        }
        if (valore < 15){

            icona.setImageResource(R.mipmap.logo_condizionatore1);

        }
    }
}
