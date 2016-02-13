package ium.dycklanguage.domotric.classi;

import java.text.DateFormat;



public class Programmazione {

    private String nomeStanza;
    private String tipoProgrammazione;
    private DateFormat oraInizio;
    private DateFormat oraFile;
    private DateFormat giornoInizio;
    private DateFormat giornoFine;

    public Programmazione(){

    }

    public String getNomeStanza() {
        return nomeStanza;
    }

    public void setNomeStanza(String nomeStanza) {
        this.nomeStanza = nomeStanza;
    }

    public String getTipoProgrammazione() {
        return tipoProgrammazione;
    }

    public void setTipoProgrammazione(String tipoProgrammazione) {
        this.tipoProgrammazione = tipoProgrammazione;
    }

    public DateFormat getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(DateFormat oraInizio) {
        this.oraInizio = oraInizio;
    }

    public DateFormat getOraFile() {
        return oraFile;
    }

    public void setOraFile(DateFormat oraFile) {
        this.oraFile = oraFile;
    }

    public DateFormat getGiornoInizio() {
        return giornoInizio;
    }

    public void setGiornoInizio(DateFormat giornoInizio) {
        this.giornoInizio = giornoInizio;
    }

    public DateFormat getGiornoFine() {
        return giornoFine;
    }

    public void setGiornoFine(DateFormat giornoFine) {
        this.giornoFine = giornoFine;
    }
}
