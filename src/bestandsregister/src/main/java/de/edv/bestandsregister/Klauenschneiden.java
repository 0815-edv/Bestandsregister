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
public class Klauenschneiden {
    
    private int klauenID;
    private int schafID;
    private Date Datum;

    public Klauenschneiden(int schafID) {
        this.schafID = schafID;
    }
    
    public Klauenschneiden(int schafID, int klauenID){
        this.schafID = schafID;
        this.klauenID = klauenID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }
    
    
    
}
