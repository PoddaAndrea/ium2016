package ium.dycklanguage.domotric.classi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ium.dycklanguage.domotric.R;


public class Listatore extends ArrayAdapter<Programmazione> {

    private Activity context;
    private ArrayList<Programmazione> pr;

    public Listatore(Activity context, ArrayList<Programmazione> pr) {

        super(context, R.layout.programmata, pr);	//associo la classe al layout

        this.context = context;	//non ne ho idea, ma si
        this.pr = pr;
    }

    /**visualizza il nome nella lista indicata*/
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.programmata, null, true);	//infila il file xml nell' intent

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nomeAzione);
        TextView stanza = (TextView) rowView.findViewById(R.id.stanzaProgr);
        TextView dataEora = (TextView) rowView.findViewById(R.id.nomeParametro);

        txtTitle.setText(pr.get(position).getNome());
        stanza.setText(pr.get(position).getNomeStanza());
        dataEora.setText(pr.get(position).getTipoProgrammazione());

        return rowView;

    }

}

