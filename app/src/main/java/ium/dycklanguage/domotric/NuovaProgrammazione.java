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
import android.widget.CheckedTextView;
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

    EditText oraInizio, oraFine, nome;
    DatePickerFragment[] datePickerFragment = new DatePickerFragment[2];
    TextView errorText,  erroreOI, erroreOF, errorStanza, errorTipo;
    static TextView regolazioneParametro, valoreParametro;
    //CheckedTextView tuttoIlGiorno;
    Integer min = 0, max = 40, valore = 20;
    ImageView meno, piu;

    String scelta;
    String[] stanze = new String[3];
    boolean[] isResumed = new boolean[4];
    Button conferma;
    CheckedTextView riscaldamentoC, luceC, tapparelleC, cucinaC, cameraC, saloneC;
    View riscaldamentoV, luceV, tapparelleV;
    String[] flahes = new String[3];
    ArrayList<String> stanzeScelte = new ArrayList<>();
    String[] tlahes = new String[3];
    ArrayList<String> tipoScelto = new ArrayList<>();

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

        errorText = (TextView) findViewById(R.id.errorText);

        erroreOI = (TextView) findViewById(R.id.errorTextOI);
        erroreOF = (TextView) findViewById(R.id.errorTextOF);
        regolazioneParametro = (TextView) findViewById(R.id.nomeRegolazione);
        valoreParametro = (TextView) findViewById(R.id.valoreP);

        meno = (ImageView) findViewById(R.id.menoNP);
        piu = (ImageView) findViewById(R.id.piuNP);

        //regolazioneParametro.setText("Intensità luce");
        valoreParametro.setText(valore.toString() +"°C");

        riscaldamentoC = (CheckedTextView) findViewById(R.id.checkedTextViewRiscaldamento);
        tapparelleC = (CheckedTextView) findViewById(R.id.checkedTextViewTapparelle);
        luceC = (CheckedTextView) findViewById(R.id.checkedTextViewLuce);
        cucinaC = (CheckedTextView) findViewById(R.id.checkedTextViewCucina);
        cameraC = (CheckedTextView) findViewById(R.id.checkedTextViewCamera);
        saloneC = (CheckedTextView) findViewById(R.id.checkedTextViewSalone);

        stanzeScelte.clear();
        tipoScelto.clear();

        luceC.setChecked(false);
        tapparelleC.setChecked(false);
        riscaldamentoC.setChecked(false);

        errorStanza = (TextView) findViewById(R.id.errorTextStanza);
        errorTipo = (TextView) findViewById(R.id.errorTextTipo);

        errorStanza.setVisibility(View.GONE);
        errorTipo.setVisibility(View.GONE);

        cameraC.setChecked(false);
        cucinaC.setChecked(false);
        saloneC.setChecked(false);

        luceV = findViewById(R.id.opzioneLuce);
        tapparelleV = findViewById(R.id.opzioneTapparelle);
        riscaldamentoV = findViewById(R.id.opzioneRiscaldamento);

        luceV.setVisibility(View.GONE);
        tapparelleV.setVisibility(View.GONE);
        riscaldamentoV.setVisibility(View.GONE);

        oraInizio = (EditText) findViewById(R.id.oraINP);
        oraFine = (EditText) findViewById(R.id.oraFNP);

        // nascondiamo il messaggio di errore
        errorText.setVisibility(View.GONE);

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


        List<String> list1 = new ArrayList<>();
        list1.add("Luce");
        list1.add("Tapparelle");
        list1.add("Riscaldamento");
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list1);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        cucinaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cucinaC.isChecked() == false) {
                    cucinaC.setChecked(true);
                    flahes[0] = "Cucina";
                } else {
                    cucinaC.setChecked(false);
                    flahes[0] = null;
                }
            }
        });

        saloneC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (saloneC.isChecked() == false) {
                    saloneC.setChecked(true);
                    flahes[1] = "Salone";
                } else {
                    saloneC.setChecked(false);
                    flahes[1] = null;
                }
            }
        });

        cameraC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (cameraC.isChecked() == false) {
                    cameraC.setChecked(true);
                    flahes[2] = "Camera";
                } else {
                    cameraC.setChecked(false);
                    flahes[2] = null;
                }
            }
        });

        tapparelleC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tapparelleC.isChecked() == false) {
                    tapparelleC.setChecked(true);
                    tapparelleV.setVisibility(View.VISIBLE);
                    tlahes[2] = "Tapparelle";
                } else {
                    tapparelleC.setChecked(false);
                    tapparelleV.setVisibility(View.GONE);
                    tlahes[2] = null;

                }
            }
        });

        luceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (luceC.isChecked() == false){
                    luceC.setChecked(true);
                    luceV.setVisibility(View.VISIBLE);
                    tlahes[0] = "Luce";
                }
                else{
                    luceC.setChecked(false);
                    luceV.setVisibility(View.GONE);
                    tlahes[0] = null;

                }
            }
        });

        riscaldamentoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (riscaldamentoC.isChecked() == false) {
                    riscaldamentoC.setChecked(true);
                    riscaldamentoV.setVisibility(View.VISIBLE);
                    tlahes[1] = "Riscaldamento";
                } else {
                    riscaldamentoC.setChecked(false);
                    riscaldamentoV.setVisibility(View.GONE);
                    tlahes[1] = null;

                }
            }
        });

        meno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore > min)
                    valore--;
                valoreParametro.setText(valore.toString() +"°C");

                if (valore == 0)
                    meno.setImageResource(R.mipmap.button_meno_grey);

                if(valore == 39)
                    piu.setImageResource(R.mipmap.button_piu);

            }
        });

        piu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valore < max)
                    valore++;
                valoreParametro.setText(valore.toString() +"°C");

                if(valore == 1)
                    meno.setImageResource(R.mipmap.button_meno);

                if (valore == 40)
                    piu.setImageResource(R.mipmap.button_piu_grey);

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

                for (int i = 0; i<3; i++){
                    if (flahes[i] != null)
                        stanzeScelte.add(flahes[i]);

                    if (tlahes[i] != null)
                        tipoScelto.add(tlahes[i]);
                }

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



        MainActivity.automazione.add(new Programmazione(nome.getText().toString(),
                stanzeScelte, tipoScelto,
                oraInizio.getText().toString(), oraFine.getText().toString()));



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

        if(stanzeScelte.size() == 0){
            condizione = false;
            errorStanza.setVisibility(View.VISIBLE);
            errorTipo.setVisibility(View.GONE);
        } else {
            errorStanza.setVisibility(View.GONE);


        }

        if(tipoScelto.size() == 0){
            condizione = false;
            errorTipo.setVisibility(View.VISIBLE);
        } else {
            errorTipo.setVisibility(View.GONE);

        }

        if (nome.getText() == null || nome.getText().toString().length() == 0){

            errorText.setVisibility(View.VISIBLE);
            errorText.setText("Non hai inserito il nome dell'azione");

            condizione = false;

        } else {

            errorText.setVisibility(View.GONE);
            errorText.setText("");
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
