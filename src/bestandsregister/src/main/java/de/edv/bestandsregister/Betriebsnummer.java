/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

/**
 *
 * @author lorenz
 */
public class Betriebsnummer {

    private int betriebsID;
    private String betriebsnummer;
    private int schafID;
    private String bemerkung;

    public String getBetriebsnummer() {
        return betriebsnummer;
    }

    public void setBetriebsnummer(String betriebsnummer) {
        this.betriebsnummer = betriebsnummer;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

}
