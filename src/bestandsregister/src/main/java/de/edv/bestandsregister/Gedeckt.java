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
 * @author lorenz
 */
public class Gedeckt {

    private String gedecktID;
    private String schafID;
    private Date datum;
    private String vaterkennung;

    public Gedeckt(String schafID) {
        this.schafID = schafID;
        this.gedecktID = IdentifierService.generateGUID();
    }

    public Gedeckt(String schafID, String gedecktID) {
        this.schafID = schafID;
        this.gedecktID = gedecktID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getGedecktID() {
        return gedecktID;
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

    public String toString() {
        return vaterkennung + " " + datum.toString();
    }
}
