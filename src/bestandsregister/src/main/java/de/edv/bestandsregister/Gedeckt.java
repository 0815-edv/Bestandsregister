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
public class Gedeckt {
    
    private int gedecktID;
    private int schafID;
    private Date datum;
    private String vaterkennung;
    
    public Gedeckt(int schafID){
        this.schafID = schafID;
    }

    public Gedeckt(int schafID, int gedecktID){
        this.schafID = schafID;
        this.gedecktID = gedecktID;
    }
    
    public Date getDatum() {
        return datum;
    }

    public String getVaterkennung() {
        return vaterkennung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public void setVaterkennung(String vaterkennung) {
        this.vaterkennung = vaterkennung;
    }
}
