package ium.dycklanguage.domotric.classi;



public class Programmazione {

    private String nome;
    private String nomeStanza;
    private String tipoProgrammazione;
    private String oraInizio;
    private String oraFile;
    private String giornoInizio;
    private String giornoFine;
    private boolean attivato;

    public Programmazione(){

    }

    public Programmazione(String nome, String nomeS, String tipo, String oi, String of, String gi, String gf ){

        this.setNome(nome);
        this.setNomeStanza(nomeS);
        this.setTipoProgrammazione(tipo);
        this.setOraInizio(oi);
        this.setOraFile(of);
        this.setGiornoInizio(gi);
        this.setGiornoFine(gf);
        this.setAttivato(true);
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


    public String getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(String oraInizio) {
        this.oraInizio = oraInizio;
    }

    public String getOraFile() {
        return oraFile;
    }

    public void setOraFile(String oraFile) {
        this.oraFile = oraFile;
    }

    public String getGiornoInizio() {
        return giornoInizio;
    }

    public void setGiornoInizio(String giornoInizio) {
        this.giornoInizio = giornoInizio;
    }

    public String getGiornoFine() {
        return giornoFine;
    }

    public void setGiornoFine(String giornoFine) {
        this.giornoFine = giornoFine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAttivato() {
        return attivato;
    }

    public void setAttivato(boolean attivato) {
        this.attivato = attivato;
    }
}
