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
public class Entwurmen {

    private int entwurmenID;
    private int schafID;
    private Date datum;

    public Entwurmen(int schafID) {
        this.schafID = schafID;

    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

}
