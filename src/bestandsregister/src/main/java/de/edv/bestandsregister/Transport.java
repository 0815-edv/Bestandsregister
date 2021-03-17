/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.edv.bestandsregister;

import java.sql.Date;

/**
 *
 * @author Markus
 */
public class Transport {

    private int transportID;
    private int schafID;
    private String transportMittel;
    private String grund;
    private Date datum;

    public Transport(int schafID) {
        this.schafID = schafID;
    }

    public Transport(int schafID, int transportID) {
        this.schafID = schafID;
        this.transportID = transportID;
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

    public void setDatum(Date daum) {
        this.datum = datum;
    }
}
