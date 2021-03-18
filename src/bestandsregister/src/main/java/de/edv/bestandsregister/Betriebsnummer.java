/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

import de.edv.bestandsregister.utils.IdentifierService;

/**
 *
 * @author lorenz
 */
public class Betriebsnummer {

    private String betriebsID;
    private String betriebsnummer;
    private String schafID;
    private String bemerkung;

    public Betriebsnummer(String schafID){
        this.schafID = schafID;
        this.betriebsID = IdentifierService.generateGUID();
    }
    
    public Betriebsnummer(String schafID, String betriebsID){
        this.schafID = schafID;
        this.betriebsID = betriebsID;
    }
    
    public String getBetriebsnummer() {
        return betriebsnummer;
    }

    public void setBetriebsnummer(String betriebsnummer) {
        this.betriebsnummer = betriebsnummer;
    }
    
    public String getBetriebsID(){
        return betriebsID;
    }
    
    public String getSchafID(){
        return schafID;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }
}
