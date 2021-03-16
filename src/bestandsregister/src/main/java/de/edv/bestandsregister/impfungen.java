/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

import java.util.Date;

/**
 *
 * @author lorenz
 */
public class Impfungen {
    int schafID;
    int ImpfID;
    String impfstoff;
    String bemerkung;
    Date datum;
    
    public void Impfungen(int SchafID){
       //here the code for the method "impfungen" 
    }

    public int getImpfID() {
        return ImpfID;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public Date getDatum() {
        return datum;
    }

    public void setImpfstoff(String impfstoff) {
        this.impfstoff = impfstoff;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    
    
    
}
