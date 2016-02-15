package ium.dycklanguage.domotric;

import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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
    //CheckedTextView tuttoIlGiorno;

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

        dataInizio = (EditText) findViewById(R.id.dataINP);
        dataFine = (EditText) findViewById(R.id.dataFNP);
        oraInizio = (EditText) findViewById(R.id.oraINP);
        oraFine = (EditText) findViewById(R.id.oraFNP);

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
                salvaeChiudi();
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


    @Override
    public void onBackPressed() {

        Intent asd = new Intent(getBaseContext(), ium.dycklanguage.domotric.Programmazione.class);

        //avvia la finestra corrispondente
        startActivity(asd);

        finish();
    }

}
