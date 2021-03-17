/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

import java.sql.Date;

/**
 *
 * @author lorenz
 */

public class Impfungen {
    private int schafID;
    private int impfID;
    private String impfstoff;
    private String bemerkung;
    private Date datum;
    
    public Impfungen(int schafID){
        this.schafID = schafID;
    }

    public int getImpfID() {
        return impfID;
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