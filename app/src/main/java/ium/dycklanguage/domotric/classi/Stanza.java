package ium.dycklanguage.domotric.classi;

/**classe descrivente la stanza e le sue regolazioni*/

public class Stanza {

    private String nome;
    private boolean illuminazione;
    private boolean tapparelle;
    private boolean riscaldamento;
    private int percentualeIlluminazione;
    private int percentualetapparelle;
    private int percentualeRiscaldamento;
    private boolean luceRegolabile;

    public Stanza(String nome){

        this.setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isIlluminazione() {
        return illuminazione;
    }

    public void setIlluminazione(boolean illuminazione) {
        this.illuminazione = illuminazione;
    }

    public boolean isTapparelle() {
        return tapparelle;
    }

    public void setTapparelle(boolean tapparelle) {
        this.tapparelle = tapparelle;
    }

    public boolean isRiscaldamento() {
        return riscaldamento;
    }

    public void setRiscaldamento(boolean riscaldamento) {
        this.riscaldamento = riscaldamento;
    }

    public int getPercentualeIlluminazione() {
        return percentualeIlluminazione;
    }

    public void setPercentualeIlluminazione(int percentualeIlluminazione) {
        this.percentualeIlluminazione = percentualeIlluminazione;
    }

    public int getPercentualetapparelle() {
        return percentualetapparelle;
    }

    public void setPercentualetapparelle(int percentualetapparelle) {
        this.percentualetapparelle = percentualetapparelle;
    }

    public int getPercentualeRiscaldamento() {
        return percentualeRiscaldamento;
    }

    public void setPercentualeRiscaldamento(int percentualeRiscaldamento) {
        this.percentualeRiscaldamento = percentualeRiscaldamento;
    }

    public boolean isLuceRegolabile() {
        return luceRegolabile;
    }

    public void setLuceRegolabile(boolean luceRegolabile) {
        this.luceRegolabile = luceRegolabile;
    }
}
