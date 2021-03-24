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
 * @author Markus
 */
public class Transport {

    private String transportID;
    private String schafID;
    private String transportMittel;
    private String grund;
    private Date datum;

    public Transport(String schafID) {
        this.schafID = schafID;
        this.transportID = IdentifierService.generateGUID();
    }

    public Transport(String schafID, String transportID) {
        this.schafID = schafID;
        this.transportID = transportID;
    }

    public String getTransportID() {
        return transportID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getTransportMittel() {
        return transportMittel;
    }

    public String getGrund() {
        return grund;
    }

    public Date getDatum() {
        return datum;
    }

    public void setTransportMittel(String transportMittel) {
        this.transportMittel = transportMittel;
    }

    public void setGrund(String grund) {
        this.grund = grund;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String toString() {
        return grund + " " + datum.toString();
    }
}
