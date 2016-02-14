package ium.dycklanguage.domotric.classi;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

import android.app.DialogFragment;

/**thanks to Davide Spano from University of Cagliari for this code*/

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    private final DatePicker picker = null;
    private Calendar date;

    public void setDate(Calendar date){
        this.date = date;
    }

    public Calendar getDate(){
        return this.date;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        super.onCreateDialog(savedInstanceState);

        // imposto la data di default
        if(date == null){
            date = Calendar.getInstance();
        }
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);

        // decommentare queste righe nel caso si voglia la visualizzazione
        // di un calendario e non dello spinner
        //dialog.getDatePicker().setSpinnersShown(false);
        //dialog.getDatePicker().setCalendarViewShown(true);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
        this.date.set(Calendar.YEAR, view.getYear());
        this.date.set(Calendar.MONTH, view.getMonth());
        this.date.set(Calendar.DAY_OF_MONTH, view.getDayOfMonth());
    }
}
