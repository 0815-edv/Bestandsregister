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
public class Schaf {
    
    private int schafID;
    private Date DatumZugang;
    private Date DatumAbgang;
    private String GrundFürAbgang;
    private String Kennung;
    private String Bemerkung;
    private String Mutterkennung;

    public Date getDatumZugang() {
        return DatumZugang;
    }

    public void setDatumZugang(Date DatumZugang) {
        this.DatumZugang = DatumZugang;
    }

    public Date getDatumAbgang() {
        return DatumAbgang;
    }

    public void setDatumAbgang(Date DatumAbgang) {
        this.DatumAbgang = DatumAbgang;
    }

    public String getGrundFürAbgang() {
        return GrundFürAbgang;
    }

    public void setGrundFürAbgang(String GrundFürAbgang) {
        this.GrundFürAbgang = GrundFürAbgang;
    }

    public String getKennung() {
        return Kennung;
    }

    public void setKennung(String Kennung) {
        this.Kennung = Kennung;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String Bemerkung) {
        this.Bemerkung = Bemerkung;
    }

    public String getMutterkennung() {
        return Mutterkennung;
    }

    public void setMutterkennung(String Mutterkennung) {
        this.Mutterkennung = Mutterkennung;
    }
    
    
    
}
