package ium.dycklanguage.domotric.classi;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.DatePicker;

import java.util.Calendar;

import android.app.DialogFragment;

/**thanks to Davide Spano from University of Cagliari for this code*/

public class DatePickerFragment extends DialogFragment{

    private Calendar date;
    private DatePickerFragmentListener listener;

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
            // impostiamo la data al primo gennaio del 1994
            date.set(Calendar.YEAR, 1994);
            date.set(Calendar.MONTH, Calendar.JANUARY);
            date.set(Calendar.DAY_OF_MONTH, 1);
        }

        final DatePicker datePicker = new DatePicker(getActivity());

        // togliamo il calendario e lasciamo solo lo spinner per la data
        datePicker.setSpinnersShown(true);
        datePicker.setCalendarViewShown(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // inseriamo il date picker nella dialog
        builder.setView(datePicker);
        // impostiamo i bottoni Ok e Cancel
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // questo metodo viene richiamato quando si preme il bottone ok
                date.set(Calendar.YEAR, datePicker.getYear());
                date.set(Calendar.MONTH, datePicker.getMonth());
                date.set(Calendar.DAY_OF_MONTH, datePicker.getDayOfMonth());
                // notifichiamo l'evento
                if(listener != null){
                    // notifichiamo l'evento
                    listener.onDatePickerFragmentOkButton(DatePickerFragment.this, date);
                }
            }
        });
        builder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(listener != null){
                    // notifichiamo l'evento
                    listener.onDatePickerFragmentCancelButton(DatePickerFragment.this);
                }
            }
        });



        return builder.create();
    }

    public void setOnDatePickerFragmentChanged(DatePickerFragmentListener l){
        this.listener = l;
    }

    public interface DatePickerFragmentListener{
        public void onDatePickerFragmentOkButton(DialogFragment dialog, Calendar date);
        public void onDatePickerFragmentCancelButton(DialogFragment dialog);
    }
}
