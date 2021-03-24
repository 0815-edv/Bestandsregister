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
public class Entwurmen {

    private String entwurmenID;
    private String schafID;
    private Date datum;

    public Entwurmen(String schafID) {
        this.schafID = schafID;
        this.entwurmenID = IdentifierService.generateGUID();
    }

    public Entwurmen(String schafID, String entwurmenID) {
        this.schafID = schafID;
        this.entwurmenID = entwurmenID;
    }

    public String getEntwurmenID() {
        return entwurmenID;
    }

    public String getSchafID() {
        return schafID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String toString() {
        return datum.toString();
    }
}
