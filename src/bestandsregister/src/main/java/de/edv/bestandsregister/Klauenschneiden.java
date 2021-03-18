/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

import de.edv.bestandsregister.utils.IdentifierService;
import java.sql.Date;

/**
 *
 * @author flori
 */
public class Klauenschneiden {

    private String klauenID;
    private String schafID;
    private Date Datum;

    public Klauenschneiden(String schafID) {
        this.schafID = schafID;
        this.klauenID = IdentifierService.generateGUID();
    }

    public Klauenschneiden(String schafID, String klauenID) {
        this.schafID = schafID;
        this.klauenID = klauenID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getKlauenID() {
        return klauenID;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }
}
