package ium.dycklanguage.domotric.classi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *


public class Listatore extends ArrayAdapter<Programmazione> {

    private Activity context;
    private ArrayList<Programmazione> pr;

    public Listatore(Activity context, ArrayList<Programmazione> pr) {

        super(context, R.layout.listatore, nome);	//associo la classe al layout

        this.context = context;	//non ne ho idea, ma si
        this.eventi = nome;
    }
 */
    /**visualizza il nome nella lista indicata
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.listatore, null, true);	//infila il file xml nell' intent

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nomeT);
        TextView dataEora = (TextView) rowView.findViewById(R.id.dataT);

        txtTitle.setText(eventi.get(position).getNome());

        dataEora.setText(eventi.get(position).getData() + " " + eventi.get(position).getOra());

        return rowView;

    }

}
        */
