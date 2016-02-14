package ium.dycklanguage.domotric;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import ium.dycklanguage.domotric.classi.DatePickerFragment;

public class NuovaProgrammazione extends AppCompatActivity {

    EditText dataInizio, dataFine, oraInizio, oraFine, stanza, tipo;
    DatePickerFragment[] datePickerFragment = new DatePickerFragment[2];
    CheckedTextView tuttoIlGiorno;

    String scelta;
    String[] stanze = new String[3];
    boolean[] isResumed = new boolean[4];
    Button conferma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuova_programmazione);

        isResumed[0] = false;  // utilizzo questo per gestire il focus in modo corretto
        isResumed[1] = false;
        datePickerFragment[0] = new DatePickerFragment();
        datePickerFragment[1] = new DatePickerFragment();


        stanza = (EditText) findViewById(R.id.stanzaNP);
        tipo = (EditText) findViewById(R.id.tipologiaNP);

        dataInizio = (EditText) findViewById(R.id.dataINP);
        dataFine = (EditText) findViewById(R.id.dataFNP);
        oraInizio = (EditText) findViewById(R.id.oraINP);
        oraFine = (EditText) findViewById(R.id.oraFNP);

        tuttoIlGiorno = (CheckedTextView) findViewById(R.id.checkedTextView1);

        conferma = (Button) findViewById(R.id.confermaNP);

        stanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selezionaStanza();

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
                salvaeChiudi();
            }
        });

        updateUI();
    }


    public String selezionaStanza(){

        stanze[0] = "Cucina";
        stanze[1] = "Camera";
        stanze[2] = "Salone";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scegli una stanza")
                .setItems(stanze, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        scelta = stanze[which];
                    }
                });

        builder.create();

        return scelta;
    }

    void salvaeChiudi(){


        finish();
    }

    @Override
    public void onResume(){
        super.onResume();
        isResumed[0] = true;
        isResumed[1] = true;
    }


    void updateUI(){

        stanza.setText(scelta);

    }
}
