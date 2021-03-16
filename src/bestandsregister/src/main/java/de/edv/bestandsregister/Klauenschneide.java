/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;
import java.sql.Date;
/**
 *
 * @author flori
 */
public class Klauenschneide {
    
    private int KlauenID;
    private int SchafID;
    private Date Datum;

    public Klauenschneide(int SchafID) {
        this.SchafID = SchafID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }
    
    
    
}
