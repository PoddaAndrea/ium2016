package ium.dycklanguage.domotric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Riscaldamento extends AppCompatActivity {

    ImageView piu, meno, icona;
    TextView gradi;
    Integer min = 0, max = 40, valore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riscaldamento);

        this.setTitle("Imposta riscaldamento");

        piu = (ImageView) findViewById(R.id.piuR);
        meno = (ImageView) findViewById(R.id.menoR);
        icona = (ImageView) findViewById(R.id.feedbackRiscaldamento);
        gradi = (TextView) findViewById(R.id.valoreR);

        valore = MainActivity.stanza.get(2).getPercentualeRiscaldamento();

        gradi.setText(valore.toString());


        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore > min)
                    valore--;
                gradi.setText(valore.toString());

                //// TODO: 15/02/16 inserire cambio icona
                //

                 MainActivity.stanza.get(2).setPercentualeRiscaldamento(valore);

            }
        });


        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore < max)
                    valore++;
                gradi.setText(valore.toString());

                MainActivity.stanza.get(2).setPercentualeRiscaldamento(valore);

            }
        });


    }
}
