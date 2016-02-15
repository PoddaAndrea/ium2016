package ium.dycklanguage.domotric.classi;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ium.dycklanguage.domotric.R;


public class Listatore extends ArrayAdapter<Programmazione> {

    private Activity context;
    private ArrayList<Programmazione> pr;
    int positions;

    public Listatore(Activity context, ArrayList<Programmazione> pr) {

        super(context, R.layout.programmata, pr);	//associo la classe al layout

        this.context = context;	//non ne ho idea, ma si
        this.pr = pr;
    }

    /**visualizza il nome nella lista indicata*/
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        positions = position;

        LayoutInflater inflater = context.getLayoutInflater();

        View rowView = inflater.inflate(R.layout.programmata, null, true);	//infila il file xml nell' intent

        TextView txtTitle = (TextView) rowView.findViewById(R.id.nomeAzione);
        TextView stanza = (TextView) rowView.findViewById(R.id.stanzaProgr);
        TextView dataEora = (TextView) rowView.findViewById(R.id.nomeParametro);
        final Switch attiva = (Switch) rowView.findViewById(R.id.abilitaAzione);

        txtTitle.setText(pr.get(position).getNome());
        stanza.setText(pr.get(position).getNomeStanza());
        dataEora.setText(pr.get(position).getTipoProgrammazione());

        attiva.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    attiva.setChecked(true);
                    Toast.makeText(context, "Evento " + pr.get(positions).getNome() +
                            " attivato per le " + pr.get(positions).getOraInizio() +
                            " del " + pr.get(positions).getGiornoInizio(), Toast.LENGTH_LONG).show();

                } else {

                    attiva.setChecked(false);
                    Toast.makeText(context, "Evento " + pr.get(positions).getNome() +
                            " disattivato", Toast.LENGTH_LONG).show();
                }

            }
        });

        return rowView;

    }

}

