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
public class Schaf {

    private String schafID;
    private Date datumZugang;
    private Date datumAbgang;
    private String grundFürAbgang;
    private String kennung;
    private String bemerkung;
    private String mutterkennung;

    public Schaf() {
        this.schafID = IdentifierService.generateGUID();
    }

    public Schaf(String schafID) {
        this.schafID = schafID;
    }

    public String getSchafID() {
        return schafID;
    }

    public Date getDatumZugang() {
        return datumZugang;
    }

    public void setDatumZugang(Date datumZugang) {
        this.datumZugang = datumZugang;
    }

    public Date getDatumAbgang() {
        return datumAbgang;
    }

    public void setDatumAbgang(Date datumAbgang) {
        this.datumAbgang = datumAbgang;
    }

    public String getGrundFürAbgang() {
        return grundFürAbgang;
    }

    public void setGrundFürAbgang(String grundFürAbgang) {
        this.grundFürAbgang = grundFürAbgang;
    }

    public String getKennung() {
        return kennung;
    }

    public void setKennung(String kennung) {
        this.kennung = kennung;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public String getMutterkennung() {
        return mutterkennung;
    }

    public void setMutterkennung(String mutterkennung) {
        this.mutterkennung = mutterkennung;
    }
}
