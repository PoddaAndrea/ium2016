package ium.dycklanguage.domotric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import ium.dycklanguage.domotric.classi.Stanza;

public class Riscaldamento extends AppCompatActivity {

    ImageView piu, meno, icona;
    TextView gradi, titolo;
    final Integer min = 0, max = 40;
    Integer valore;
    boolean acceso;

    static Stanza stanza;
    static int posizioneScelta;

    SeekBar slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riscaldamento);

        this.setTitle("Imposta riscaldamento");



        acceso = stanza.isRiscaldamento();

        slider = (SeekBar) findViewById(R.id.seekbarra);

        titolo = (TextView) findViewById(R.id.titoloRiscaldamento);

        titolo.setText("Riscaldamento " + stanza.getNome());

        piu = (ImageView) findViewById(R.id.piuR);
        meno = (ImageView) findViewById(R.id.menoR);
        icona = (ImageView) findViewById(R.id.feedbackRiscaldamento);
        gradi = (TextView) findViewById(R.id.valoreR);

        valore = stanza.getPercentualeRiscaldamento();

        gradi.setText(valore.toString());

        updatePic();

        slider.setMax( (max - min) );


        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    updateValue(seekBar.getProgress());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updateValue(seekBar.getProgress());
            }
        });

        icona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MainActivity.stanza.get(posizioneScelta).isRiscaldamento()){

                    icona.setImageResource(R.mipmap.logo_condizionatore);
                    MainActivity.stanza.get(posizioneScelta).setRiscaldamento(false);
                    Toast.makeText(Riscaldamento.this,
                            "Hai spento il riscaldamento in Camera", Toast.LENGTH_LONG).show();
                } else {
                    MainActivity.stanza.get(posizioneScelta).setRiscaldamento(true);
                    updatePic();
                    Toast.makeText(Riscaldamento.this,
                            "Hai acceso il riscaldamento in Camera a " + valore.toString() +
                                    "°C", Toast.LENGTH_LONG).show();
                }
            }
        });

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore > min)
                    valore--;
                gradi.setText(valore.toString());

                updatePic();

                MainActivity.stanza.get(posizioneScelta).setPercentualeRiscaldamento(valore);

            }
        });


        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore < max)
                    valore++;
                gradi.setText(valore.toString());

                updatePic();

                MainActivity.stanza.get(posizioneScelta).setPercentualeRiscaldamento(valore);

            }
        });


    }

    void updateValue(int integro){

        integro = integro > max ? max : integro;
        integro = integro < min ? min : integro;

        this.valore = integro;
        this.gradi.setText(valore.toString());
        if(this.slider.getProgress() != valore - min) {
            this.slider.setProgress(valore - min);
        }

        updatePic();

    }

    public void updatePic(){

        if(!stanza.isRiscaldamento())
            icona.setImageResource(R.mipmap.logo_condizionatore);

        else {

            if(valore >= 1)
                meno.setImageResource(R.mipmap.button_meno);

            if (valore == 40)
                piu.setImageResource(R.mipmap.button_piu_grey);

            if (valore == 0)
                meno.setImageResource(R.mipmap.button_meno_grey);

            if(valore <= 39)
                piu.setImageResource(R.mipmap.button_piu);

            if (valore < 20) {

                icona.setImageResource(R.mipmap.logo_condizionatore2);
            }
            if (valore >= 20) {

                icona.setImageResource(R.mipmap.logo_condizionatore3);

            }
            if (valore > 25) {

                icona.setImageResource(R.mipmap.logo_condizionatore4);

            }
            if (valore < 15) {

                icona.setImageResource(R.mipmap.logo_condizionatore1);

            }

        }
    }
}
