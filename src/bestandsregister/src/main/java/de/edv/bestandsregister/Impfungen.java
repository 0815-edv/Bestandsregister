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

public class Impfungen {
    private String schafID;
    private String impfID;
    private String impfstoff;
    private String bemerkung;
    private Date datum;
    
    public Impfungen(String schafID){
        this.schafID = schafID;
        this.impfID = IdentifierService.generateGUID();
    }

    public Impfungen(String schafID, String impfID){
        this.schafID = schafID;
        this.impfID = impfID;
    }
    
    public String getSchafID(){
        return schafID;
    }
      
    public String getImpfID() {
        return impfID;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public String getImpfstoff(){
        return impfstoff;
    }
    
    public Date getDatum() {
        return datum;
    }

    public void setImpfstoff(String impfstoff) {
        this.impfstoff = impfstoff;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}