package ium.dycklanguage.domotric;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ium.dycklanguage.domotric.classi.*;
import ium.dycklanguage.domotric.classi.Programmazione;

public class NuovaProgrammazione extends AppCompatActivity {

    EditText dataInizio, dataFine, oraInizio, oraFine, nome;
    Spinner stanza, tipo;
    DatePickerFragment[] datePickerFragment = new DatePickerFragment[2];
    TextView errorText, erroreDI, erroreDF, erroreOI, erroreOF;
    static TextView regolazioneParametro, valoreParametro;
    //CheckedTextView tuttoIlGiorno;
    Integer min = 1, max = 5, valore = 3;
    ImageView meno, piu;

    String scelta;
    String[] stanze = new String[3];
    boolean[] isResumed = new boolean[4];
    Button conferma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuova_programmazione);

        this.setTitle("Nuova programmazione");

        isResumed[0] = false;  // utilizzo questo per gestire il focus in modo corretto
        isResumed[1] = false;
        datePickerFragment[0] = new DatePickerFragment();
        datePickerFragment[1] = new DatePickerFragment();

        nome = (EditText) findViewById(R.id.nomeNP);
        stanza = (Spinner) findViewById(R.id.stanzaNP);
        tipo = (Spinner) findViewById(R.id.tipologiaNP);
        errorText = (TextView) findViewById(R.id.errorText);
        erroreDI = (TextView) findViewById(R.id.errorTextDi);
        erroreDF = (TextView) findViewById(R.id.errorTextDF);
        erroreOI = (TextView) findViewById(R.id.errorTextOI);
        erroreOF = (TextView) findViewById(R.id.errorTextOF);
        regolazioneParametro = (TextView) findViewById(R.id.nomeRegolazione);
        valoreParametro = (TextView) findViewById(R.id.valoreP);

        meno = (ImageView) findViewById(R.id.menoNP);
        piu = (ImageView) findViewById(R.id.piuNP);

        regolazioneParametro.setText("Intensità luce");
        valoreParametro.setText(valore.toString());

        dataInizio = (EditText) findViewById(R.id.dataINP);
        dataFine = (EditText) findViewById(R.id.dataFNP);
        oraInizio = (EditText) findViewById(R.id.oraINP);
        oraFine = (EditText) findViewById(R.id.oraFNP);

        // nascondiamo il messaggio di errore
        errorText.setVisibility(View.GONE);
        erroreDI.setVisibility(View.GONE);
        erroreDF.setVisibility(View.GONE);
        erroreOI.setVisibility(View.GONE);
        erroreOF.setVisibility(View.GONE);
        errorText.setText("");
        //tuttoIlGiorno = (CheckedTextView) findViewById(R.id.checkedTextView1);

        conferma = (Button) findViewById(R.id.confermaNP);


        List<String> list = new ArrayList<>();
        list.add("Cucina");
        list.add("Camera");
        list.add("Salone");
        list.add("Tutta la casa");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stanza.setAdapter(dataAdapter);


        List<String> list1 = new ArrayList<>();
        list1.add("Luce");
        list1.add("Tapparelle");
        list1.add("Riscaldamento");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(dataAdapter1);

        tipo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                switch (position) {
                    case 0:
                        NuovaProgrammazione.regolazioneParametro.setText("Intensità luce");
                        min = 1;
                        valore = 3;
                        max = 5;
                        valoreParametro.setText(valore.toString());
                        break;
                    case 1:
                        NuovaProgrammazione.regolazioneParametro.setText("Altezza tapparelle");
                        max = 10;
                        valore = 5;
                        min = 0;
                        valoreParametro.setText(valore.toString());
                        break;
                    case 2:
                        NuovaProgrammazione.regolazioneParametro.setText("Gradi riscaldamento");
                        max = 40;
                        valore = 22;
                        valoreParametro.setText(valore.toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore > min)
                    valore--;
                valoreParametro.setText(valore.toString());

            }
        });

        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore < max)
                    valore++;
                valoreParametro.setText(valore.toString());

            }
        });

        /**time picker data inizio*/
        dataInizio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerFragment[0].show(getFragmentManager(), "datePicker");
            }
        });

        dataInizio.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus && isResumed[0]) {
                    datePickerFragment[0].show(getFragmentManager(), "datePicker");
                }
            }
        });

        // ci registriamo agli eventi del popup (ok e annulla)
        datePickerFragment[0].setOnDatePickerFragmentChanged(new DatePickerFragment.DatePickerFragmentListener() {
            @Override
            public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date) {
                // trasferiamo il valore sul campo di testo
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dataInizio.setText(format.format(date.getTime()));
            }

            @Override
            public void onDatePickerFragmentCancelButton(DialogFragment dialog) {
                // non facciamo nulla
            }
        });


        /**time picker data fine*/
        dataFine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerFragment[1].show(getFragmentManager(), "datePicker");
            }
        });

        dataFine.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus && isResumed[1]) {
                    datePickerFragment[1].show(getFragmentManager(), "datePicker");
                }
            }
        });

        datePickerFragment[1].setOnDatePickerFragmentChanged(new DatePickerFragment.DatePickerFragmentListener() {
            @Override
            public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date) {
                // trasferiamo il valore sul campo di testo
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                dataFine.setText(format.format(date.getTime()));
            }

            @Override
            public void onDatePickerFragmentCancelButton(DialogFragment dialog) {
                // non facciamo nulla
            }
        });


        oraInizio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(NuovaProgrammazione.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        oraInizio.setText("" + selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Seleziona l'ora di inizio");
                mTimePicker.show();

            }
        });

        oraInizio.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus && isResumed[1]) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(NuovaProgrammazione.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            oraInizio.setText("" + selectedHour + ":" + selectedMinute);
                        }
                    }, hour, minute, true);//Yes 24 hour time
                    mTimePicker.setTitle("Seleziona l'ora di inizio");
                    mTimePicker.show();
                }
            }
        });

        oraFine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(NuovaProgrammazione.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        oraInizio.setText("" + selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Seleziona l'ora di fine");
                mTimePicker.show();

            }
        });

        oraFine.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus && isResumed[1]) {
                    Calendar mcurrentTime = Calendar.getInstance();
                    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                    int minute = mcurrentTime.get(Calendar.MINUTE);
                    TimePickerDialog mTimePicker;
                    mTimePicker = new TimePickerDialog(NuovaProgrammazione.this, new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                            oraFine.setText("" + selectedHour + ":" + selectedMinute);
                        }
                    }, hour, minute, true);//Yes 24 hour time
                    mTimePicker.setTitle("Seleziona l'ora di inizio");
                    mTimePicker.show();
                }
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkError())
                    salvaeChiudi();
                else
                    Toast.makeText(NuovaProgrammazione.this,
                            "Ci sono degli errori nella programmazione dell'azione.\n" +
                            "Ricontrolla i campi segnati", Toast.LENGTH_LONG).show();
            }
        });

        updateUI();
    }

    void salvaeChiudi(){

        String nomeEvento = nome.getText().toString();

        MainActivity.automazione.add(new Programmazione(nome.getText().toString(), stanza.getSelectedItem().toString(),
                tipo.getSelectedItem().toString(),
                oraInizio.getText().toString(), oraFine.getText().toString(),
                dataInizio.getText().toString(), dataFine.getText().toString()));

        //Toast
        Toast.makeText(this, "Nuovo evento " + nomeEvento + " creato!",Toast.LENGTH_LONG).show();

        Intent asd = new Intent(getBaseContext(), ium.dycklanguage.domotric.Programmazione.class);

        //avvia la finestra corrispondente
        startActivity(asd);
        finish();
    }

    @Override
    public void onResume(){
        super.onResume();
        isResumed[0] = true;
        isResumed[1] = true;
    }


    void updateUI(){


    }

    public boolean checkError(){

        boolean condizione = true;

        if (nome.getText() == null || nome.getText().toString().length() == 0){

            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Non hai inserito il nome dell'azione");

            condizione = false;

        } else {

            errorText.setVisibility(View.GONE);
            errorText.setText("");
        }

        if (dataInizio.getText() == null || dataInizio.getText().toString().length() == 0){

            erroreDI.setVisibility(View.VISIBLE);
            erroreDI.setText("Non hai inserito la data iniziale");

            condizione = false;

        } else {

            erroreDI.setVisibility(View.GONE);
            erroreDI.setText("");
        }

        if (dataFine.getText() == null || dataFine.getText().toString().length() == 0){

            erroreDF.setVisibility(View.VISIBLE);
            erroreDF.setText("Non hai inserito la data della fine");

            condizione = false;

        } else {

            erroreDF.setVisibility(View.GONE);
            erroreDF.setText("");
        }

        if (oraInizio.getText() == null || oraInizio.getText().toString().length() == 0){

            erroreOI.setVisibility(View.VISIBLE);
            erroreOI.setText("Non hai inserito l'orario d'inizio");

            condizione = false;

        } else {

            erroreOI.setVisibility(View.GONE);
            erroreOI.setText("");
        }

        if (oraFine.getText() == null || oraFine.getText().toString().length() == 0){

            erroreOF.setVisibility(View.VISIBLE);
            erroreOF.setText("Non hai inserito la data finale");

            condizione = false;

        } else {

            erroreOF.setVisibility(View.GONE);
            erroreOF.setText("");
        }

        return condizione;
    }

    @Override
    public void onBackPressed() {

        Intent asd = new Intent(getBaseContext(), ium.dycklanguage.domotric.Programmazione.class);

        //avvia la finestra corrispondente
        startActivity(asd);

        finish();
    }

}
