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
public class Schur {

    private String schurID;
    private String schafID;
    private Date datum;

    public Schur(String schafID) {
        this.schafID = schafID;
        this.schurID = IdentifierService.generateGUID();
    }

    public Schur(String schafID, String schurID) {
        this.schafID = schafID;
        this.schurID = schurID;
    }

    public String getSchafID() {
        return schafID;
    }

    public String getSchurID() {
        return schurID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    public String toString(){
        return datum.toString();
    }
}
